package edu.yangao.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.yangao.entity.enums.SideEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author YangAo
 * @Description 零件信息 主要属性 传输类
 * @create 2022-08-23 17:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "零件信息 主要属性 传输类")
public class PartMajorDTO {

    /**
     * 零件id
     */
    @Min(1)
    @Schema(description = "零件id")
    private Integer id;

    /**
     * 零件名称
     */
    @NotBlank
    @Length(max = 20)
    @Schema(description = "零件名称")
    private String name;

    /**
     * 零件所属面(0-右侧, 1-左侧, 2-底部)——零件是哪个面的
     */
    @NotNull
    @Schema(description = "零件所属面(0-右侧, 1-左侧, 2-底部)——零件是哪个面的")
    private SideEnum side;

    /**
     * 坐标 {"x":0, "y":0}
     * json格式字符串
     */
    @Pattern(regexp = "^\\{\"x\":\\d{1,3},\"y\":\\d{1,3}}", flags = Pattern.Flag.COMMENTS)
    @Schema(description = "坐标 {\"x\":0, \"y\":0} ——json格式字符串")
    private String position;

    /**
     * 三维坐标{"x":0, "y":0, "z": 0}
     * json格式字符串
     */
    @Pattern(regexp = "^\\{\"x\":\\d{1,3},\"y\":\\d{1,3},\"z\":\\d{1,3}}", flags = Pattern.Flag.COMMENTS)
    @Schema(description = "三维坐标{\"x\":0, \"y\":0, \"z\": 0}——json格式字符串")
    private String threePosition;

    /**
     * 具体描述(车型+车厢+零件名)
     */
    @NotBlank
    @Length(max = 60)
    @Schema(description = "具体描述(车型+车厢+零件名)")
    private String description;

    /**
     * 车厢id
     */
    @NotNull
    @Min(1)
    @Schema(description = "车厢id")
    private Integer subwayCarriageId;
}
