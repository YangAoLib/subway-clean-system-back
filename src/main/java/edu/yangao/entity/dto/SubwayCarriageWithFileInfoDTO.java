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
 * @Description 携带对应文件信息的车厢信息
 * @create 2022-08-23 18:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "携带对应文件信息的车厢信息")
public class SubwayCarriageWithFileInfoDTO {

    /**
     * 车厢信息
     */
    @Schema(description = "车厢信息")
    private SubwayCarriageMajorDTO subwayCarriage;

    /**
     * 对应的文件信息
     */
    @Schema(description = "对应的文件信息")
    private Map<FileTypeEnum, List<FileInfoMajorDTO>> fileTotalInfoMap;

}
