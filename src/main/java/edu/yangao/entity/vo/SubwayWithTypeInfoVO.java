package edu.yangao.entity.vo;

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
 * @Description 地铁信息与类型名称
 * @create 2022-09-19 16:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁信息与类型名称")
public class SubwayWithTypeInfoVO {

    /**
     * 地铁id
     */
    @Min(1)
    @Schema(description = "地铁编号")
    private Integer id;

    /**
     * 地铁名
     */
    @Length(max = 8)
    @Schema(description = "地铁名")
    private String name;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 地铁型号名称
     */
    @Length(max = 11)
    @Schema(description = "地铁型号名称")
    private String subwayTypeName;
}
