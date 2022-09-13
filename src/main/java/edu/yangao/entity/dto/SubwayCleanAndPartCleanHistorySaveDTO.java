package edu.yangao.entity.dto;

import edu.yangao.entity.enums.PatternEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author YangAo
 * @Description 地铁清理记录 与 零件清理记录 保存信息传输类
 * @create 2022-08-25 13:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁清理记录 与 零件清理记录 保存信息传输类")
public class SubwayCleanAndPartCleanHistorySaveDTO {

    /**
     * 地铁id
     */
    @NotNull
    @Min(1)
    @Schema(description = "地铁id")
    private Integer subwayId;

    /**
     * 清理模式
     */
    @NotNull
    @Schema(description = "清理模式")
    private PatternEnum pattern;

    /**
     * 需要进行清理的零件列表
     */
    @NotEmpty
    @Schema(description = "需要进行清理的零件列表")
    private List<Integer> partIdList;
}
