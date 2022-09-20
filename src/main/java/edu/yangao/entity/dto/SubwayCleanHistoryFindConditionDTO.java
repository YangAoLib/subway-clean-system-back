package edu.yangao.entity.dto;

import edu.yangao.entity.enums.CleanStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @author YangAo
 * @Description 地铁清理记录查找条件 传输类
 * @create 2022-09-15 18:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁清理记录查找条件 传输类")
public class SubwayCleanHistoryFindConditionDTO {

    /**
     * 要查找的清理记录id
     */
    @Min(1)
    @Schema(description = "地铁清理记录id")
    private Integer id;

    /**
     * 地铁名称
     */
    @Length(max = 255)
    @Schema(description = "地铁名称")
    private String subwayName;

    /**
     * 清理状态
     */
    @Schema(description = "清理状态")
    private CleanStateEnum status;

    /**
     * 创建时间起始
     */
    @Schema(description = "创建时间起始")
    private Date createTimeStart;

    /**
     * 创建时间结尾
     */
    @Schema(description = "创建时间结尾")
    private Date createTimeEnd;

    /**
     * 当前页面数
     */
    @Min(1)
    @Schema(description = "当前页面数")
    private Integer currentPage;

    /**
     * 每页记录数
     */
    @Min(1)
    @Schema(description = "每页记录数")
    private Integer pageSize;

}
