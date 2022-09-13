package edu.yangao.mapper;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.FileInfo;
import edu.yangao.entity.enums.FileTypeEnum;
import edu.yangao.entity.enums.ObjTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangAo
 * @Description
 * @create 2022-08-24 14:28
 */
class FileInfoMapperTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Test
    void selectAllByObjIdAndObjTypeAndFileType() {
        System.out.println(fileInfoMapper.selectAllByObjIdAndObjTypeAndFileType(1, ObjTypeEnum.SUBWAY_CARRIAGE, FileTypeEnum.POINT_CLOUD));
    }

    @Test
    void insertTest() {
        ObjTypeEnum objType =  ObjTypeEnum.PART;

        int objId = 1;
        int objEnd = 10;
        FileTypeEnum[] fileTypeEnums = FileTypeEnum.values();
        for (;objId <= objEnd; objId++) {
            for (FileTypeEnum fileType : fileTypeEnums) {
                FileInfo info = FileInfo.builder()
                        .objId(objId)
                        .objType(objType)
                        .fileType(fileType)

                        .fileAddress("测试地址")
                        .currentName("测试生成名")
                        .originName("测试原名")
                        .description("测试描述")
                        .build();
                fileInfoMapper.insert(info);
            }
        }


    }
}
