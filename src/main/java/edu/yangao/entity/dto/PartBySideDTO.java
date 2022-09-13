package edu.yangao.entity.dto;

import edu.yangao.entity.enums.SideEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangAo
 * @Description 零件信息 带有所属面描述
 * @create 2022-08-25 9:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "零件信息 带有所属面描述")
public class PartBySideDTO {

    /**
     * 零件所属面
     */
    @Schema(description = "零件所属面")
    private SideEnum side;

    /**
     * 零件主属性
     */
    @Schema(description = "零件主属性")
    private List<PartMajorDTO> parts;
}
