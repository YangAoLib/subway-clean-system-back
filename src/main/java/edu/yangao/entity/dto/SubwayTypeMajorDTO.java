package edu.yangao.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author YangAo
 * @Description 地铁类型 主要属性 传输类
 * @create 2022-08-24 9:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "地铁类型 主要属性 传输类")
public class SubwayTypeMajorDTO {

    /**
     * 地铁型号id
     */
    @Min(1)
    @Schema(description = "地铁型号id")
    private Integer id;

    /**
     * 地铁型号名称
     */
    @NotBlank
    @Length(max = 11)
    @Schema(description = "地铁型号名称")
    private String name;
}
