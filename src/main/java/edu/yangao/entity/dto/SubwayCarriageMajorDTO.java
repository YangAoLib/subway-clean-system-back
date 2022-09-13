package edu.yangao.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author YangAo
 * @Description 地铁车厢 主要属性 传输类
 * @create 2022-08-23 17:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Schema(description = "地铁车厢 主要属性 传输类")
public class SubwayCarriageMajorDTO {

    /**
     * 地铁车厢id
     */
    @Min(1)
    @Schema(description = "地铁车厢id")
    private Integer id;

    /**
     * 地铁车厢名称
     */
    @NotBlank
    @Length(max = 50)
    @Schema(description = "地铁车厢名称")
    private String name;

    /**
     * 车厢编号(第几节车厢)
     */
    @NotNull
    @Min(1)
    @Schema(description = "车厢编号(第几节车厢)")
    private Integer num;

    /**
     * 所属地铁型号id
     */
    @NotNull
    @Min(1)
    @Schema(description = "所属地铁型号id")
    private Integer subwayTypeId;
}
