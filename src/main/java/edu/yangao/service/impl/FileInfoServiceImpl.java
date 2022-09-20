package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.FileInfo;
import edu.yangao.entity.dto.FileInfoWithExpireTimeDTO;
import edu.yangao.entity.enums.FileTypeEnum;
import edu.yangao.entity.enums.ObjTypeEnum;
import edu.yangao.mapper.FileInfoMapper;
import edu.yangao.service.FileInfoService;
import edu.yangao.util.BeanUtil;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.FileUtil;
import edu.yangao.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author YangAo
 * @description 针对表【file_info(文件存储信息)】的数据库操作Service实现
 * @createDate 2022-08-22 17:49:58
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo>
        implements FileInfoService {


    @Override
    public <T> Map<FileTypeEnum, List<T>> getAllTypesOfFilesByObjIdAndObjType(Integer objId, ObjTypeEnum objType, Class<T> target) {
        Map<FileTypeEnum, List<T>> map = new HashMap<>(FileTypeEnum.values().length);
        // 遍历 文件类型枚举 给每个车厢查找对应的文件 并 转化为对应的类型
        for (FileTypeEnum fileType : FileTypeEnum.values()) {
            List<FileInfo> fileInfos = baseMapper.selectAllByObjIdAndObjTypeAndFileType(objId, objType, fileType);
            map.put(fileType, BeanUtil.copyList(fileInfos, target));
        }
        return map;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        // 上传文件
        FileInfo fileInfo;
        try {
            fileInfo = fileUtil.uploadFile(file);
        } catch (IOException e) {
            throw new CustomServiceException("文件存储失败请重新上传或联系管理人员", ResultCode.FILE_UPLOAD_ERROR, e);
        }
        // 生成key存储文件信息
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        FileInfoWithExpireTimeDTO fileWithExpire = new FileInfoWithExpireTimeDTO(fileInfo, 1L, TimeUnit.HOURS);
        redisTemplate.opsForValue().set(fileUtil.getRedisDir() + ":" + uuid, fileWithExpire);
        return uuid;
    }

    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
}




