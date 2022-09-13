package edu.yangao.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author YangAo
 * @Description 地铁信息 主要属性 传输类
 * @create 2022-08-24 9:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "地铁信息 主要属性 传输类")
public class SubwayMajorDTO {

    /**
     * 地铁id
     */
    @Min(1)
    @Schema(description = "地铁编号")
    private Integer id;

    /**
     * 地铁名
     */
    @NotBlank
    @Length(max = 8)
    @Schema(description = "地铁名")
    private String name;

    /**
     * 地铁型号id
     */
    @NotNull
    @Min(1)
    @Schema(description = "地铁型号id")
    private Integer subwayTypeId;
}
