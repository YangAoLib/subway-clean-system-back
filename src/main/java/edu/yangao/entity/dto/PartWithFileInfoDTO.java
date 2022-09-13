package edu.yangao.entity.dto;

import edu.yangao.entity.enums.FileTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author YangAo
 * @Description 携带有对应文件的零件信息
 * @create 2022-08-23 17:02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "携带有对应文件的零件信息")
public class PartWithFileInfoDTO {

    /**
     * 零件属性
     */
    private PartMajorDTO part;

    /**
     * 对应的文件信息
     */
    private Map<FileTypeEnum, List<FileInfoMajorDTO>> fileTotalInfoMap;
}
