package edu.yangao.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.yangao.entity.enums.CleanStateEnum;
import edu.yangao.entity.enums.PatternEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author YangAo
 * @Description 地铁清理记录主要信息 传输类
 * @create 2022-09-15 18:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "地铁清理记录主要信息 传输类")
public class SubwayCleanHistoryMajorDTO {

    /**
     * 地铁清理记录id
     */
    @Min(1)
    @Schema(description = "地铁清理记录id")
    private Integer id;

    /**
     * 清理的地铁id
     */
    @NotNull
    @Min(1)
    @Schema(description = "清理的地铁id")
    private Integer subwayId;

    /**
     * 清理模式(0-简易清理、深度清理)
     */
    @NotNull
    @Schema(description = "清理模式(0-简易清理、深度清理)")
    private PatternEnum pattern;


    /**
     * 清理状态(0-进行中(默认)、1-完成、2-终止)
     */
    @NotNull
    @Schema(description = "清理状态(0-进行中(默认)、1-完成、2-终止)")
    private CleanStateEnum status;

    /**
     * 清理进度
     */
    @Range(max = 100)
    @Schema(description = "清理进度")
    private Integer cleanProgress;

    /**
     * 清理开始时间
     */
    @Schema(description = "清理开始时间")
    private Date createTime;

    /**
     * 清理结束时间
     */
    @Schema(description = "清理结束时间")
    private Date endTime;
}
