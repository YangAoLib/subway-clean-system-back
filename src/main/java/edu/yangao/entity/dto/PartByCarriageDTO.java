package edu.yangao.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangAo
 * @Description 按车厢分组 零件信息携带文件信息
 * @create 2022-08-25 16:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "按车厢分组 零件信息携带文件信息")
public class PartByCarriageDTO {

    /**
     * 车厢信息
     */
    private SubwayCarriageMajorDTO subwayCarriage;

    /**
     * 零件信息携带文件信息
     */
    private List<PartWithFileInfoDTO> partsWithFile;
}
