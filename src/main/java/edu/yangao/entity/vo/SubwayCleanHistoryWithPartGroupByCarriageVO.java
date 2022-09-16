package edu.yangao.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.yangao.entity.dto.PartByCarriageDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryMajorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangAo
 * @Description 地铁清理记录基础信息 与其相关的零件(根据车厢分组) 信息
 * @create 2022-09-16 13:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "地铁清理记录基础信息 与其相关的零件(根据车厢分组) 信息")
public class SubwayCleanHistoryWithPartGroupByCarriageVO {

    /**
     * 地铁清理记录 基础信息
     */
    @Schema(description = "地铁清理记录 基础信息")
    private SubwayCleanHistoryMajorDTO subwayCleanHistory;

    /**
     * 根据车厢分组的零件信息
     */
    @Schema(description = "根据车厢分组的零件信息")
    private List<PartByCarriageDTO> parts;
}
