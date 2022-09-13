package edu.yangao.mapper;
import edu.yangao.entity.enums.FileTypeEnum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.yangao.entity.FileInfo;
import edu.yangao.entity.enums.ObjTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangAo
 * @description 针对表【file_info(文件存储信息)】的数据库操作Mapper
 * @createDate 2022-08-22 17:49:58
 * @Entity edu.yangao.entity.FileInfo
 */
@Mapper
public interface FileInfoMapper extends BaseMapper<FileInfo> {
    /**
     * 根据所属对象id、类型、文件类型进行文件信息查找
     * @param objId 所属对象id
     * @param objType 所属对象类型
     * @param fileType 文件类型
     * @return 文件信息列表
     */
    List<FileInfo> selectAllByObjIdAndObjTypeAndFileType(@Param("objId") Integer objId, @Param("objType") ObjTypeEnum objType, @Param("fileType") FileTypeEnum fileType);
}




