package edu.yangao.entity.dto;

import edu.yangao.entity.enums.CleanStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author YangAo
 * @Description 地铁清理记录状态变更 传输类
 * @create 2022-09-16 15:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁清理记录状态变更 传输类")
public class SubwayCleanHistoryUpdateStatusDTO {

    /**
     * 地铁清理记录id
     */
    @Min(1)
    @Schema(description = "地铁清理记录id")
    private Integer id;

    /**
     * 清理进度
     */
    @Range(min = 0, max = 100)
    @Schema(description = "清理进度")
    private Integer cleanProgress;

    /**
     * 清理状态
     */
    @Schema(description = "清理状态")
    private CleanStateEnum status;
}
