package edu.yangao.entity.dto;

import edu.yangao.entity.enums.CleanStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author YangAo
 * @Description 零件清理记录更新 信息传输类
 * @create 2022-09-16 16:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "零件清理记录更新 信息传输类")
public class PartCleanHistoryUpdateDTO {

    /**
     * 被清理的零件id
     */
    @NotNull
    @Min(1)
    @Schema(description = "被清理的零件id")
    private Integer partId;

    /**
     * 地铁清理历史记录id
     */
    @NotNull
    @Min(1)
    @Schema(description = "地铁清理历史记录id")
    private Integer cleanHistoryId;

    /**
     * 清理状态(0-进行中(默认)、1-完成、2-终止)
     */
    @NotNull
    @Schema(description = "清理状态(0-进行中(默认)、1-完成、2-终止)")
    private CleanStateEnum status;
}
