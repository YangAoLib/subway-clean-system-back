package edu.yangao.entity.vo;

import edu.yangao.entity.dto.SubwayCarriageWithFileInfoDTO;
import edu.yangao.entity.dto.SubwayTypeMajorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author YangAo
 * @Description 地铁基本信息 及其 类型与车厢 信息
 * @create 2022-08-24 9:44
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "地铁基本信息 及其 类型与车厢 信息")
public class SubwayWithTypeAndCarriageInfoVO {

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

    /**
     * 地铁类型 基本信息
     */
    @Schema(description = "地铁类型 基本信息")
    private SubwayTypeMajorDTO subwayTypeInfo;

    /**
     * 地铁车厢及其对应文件信息
     */
    @Schema(description = "地铁车厢及其对应文件信息")
    private List<SubwayCarriageWithFileInfoDTO> subwayCarriageWithFileInfoList;

    /**
     * 地铁车厢数量
     */
    @Schema(description = "地铁车厢数量")
    private Integer subwayCarriageCount;
}
