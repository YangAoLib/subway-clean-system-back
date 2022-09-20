package edu.yangao.entity.dto;

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
 * @Description 地铁信息查找条件 传输类
 * @create 2022-09-19 17:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁信息查找条件 传输类")
public class SubwayFindConditionDTO {

    /**
     * 地铁名
     */
    @Length(max = 8)
    @Schema(description = "地铁名")
    private String name;

    /**
     * 车型名称
     */
    @Length(max = 11)
    @Schema(description = "车型名称")
    private String subwayTypeName;

    /**
     * 创建时间起始
     */
    @Schema(description = "创建时间起始")
    private Date createTimeStart;

    /**
     * 创建时间结束
     */
    @Schema(description = "创建时间结束")
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
