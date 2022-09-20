package edu.yangao.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.yangao.entity.dto.PartMajorDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryMajorDTO;
import edu.yangao.entity.dto.SubwayMajorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangAo
 * @Description 地铁清理记录和零件信息
 * @create 2022-09-15 18:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "地铁清理记录和零件信息 ")
public class SubwayCleanHistoryWithPartAndSubwayInfoVO {

    /**
     * 地铁信息
     */
    @Schema(description = "地铁信息")
    private SubwayMajorDTO subway;

    /**
     * 清理记录信息
     */
    @Schema(description = "清理记录信息")
    private SubwayCleanHistoryMajorDTO subwayCleanHistory;

    /**
     * 相关零件基础信息
     */
    @Schema(description = "相关零件基础信息")
    private List<PartMajorDTO> parts;

}
