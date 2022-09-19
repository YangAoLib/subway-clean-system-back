package edu.yangao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.FileInfo;
import edu.yangao.entity.enums.FileTypeEnum;
import edu.yangao.entity.enums.ObjTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* @author YangAo
* @description 针对表【file_info(文件存储信息)】的数据库操作Service
* @createDate 2022-08-22 17:49:58
*/
public interface FileInfoService extends IService<FileInfo> {

    /**
     * 根据 所属对象id、类型 查找其所有类型的文件, 并将其数组转化为对应形式.
     *
     * @param objId   所属对象id
     * @param objType 所属对象类型
     * @param target  转化的目标类型, 需要可以接受 FileInfo 中的属性(属性名相同)
     * @param <T>     转化的目标类型
     * @return 类型与文件列表相对应的Map
     */
    <T> Map<FileTypeEnum, List<T>> getAllTypesOfFilesByObjIdAndObjType(Integer objId, ObjTypeEnum objType, Class<T> target);

    /**
     * 上传存储文件, 并将其基础信息存入redis
     * @param file 文件
     * @return redis中对应的key
     */
    String uploadFile(MultipartFile file);
}
