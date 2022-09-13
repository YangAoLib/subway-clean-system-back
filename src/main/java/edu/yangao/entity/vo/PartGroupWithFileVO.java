package edu.yangao.entity.vo;

import edu.yangao.entity.dto.PartBySideDTO;
import edu.yangao.entity.dto.PartWithFileInfoDTO;
import edu.yangao.entity.enums.SideEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author YangAo
 * @Description 根据位置分组的零件信息, 并携带对应的文件信息
 * @create 2022-08-24 17:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "根据位置分组的零件信息, 并携带对应的文件信息")
public class PartGroupWithFileVO {

    /**
     * 地铁车厢id
     */
    @Schema(description = "地铁车厢id")
    private Integer subwayCarriageId;

    /**
     * 左侧零件组信息
     */
    @Schema(description = "左侧零件组信息")
    private List<PartWithFileInfoDTO> left;
    /**
     * 右侧零件组信息
     */
    @Schema(description = "右侧零件组信息")
    private List<PartWithFileInfoDTO> right;
    /**
     * 底部零件组信息
     */
    @Schema(description = "底部零件组信息")
    private List<PartWithFileInfoDTO> bottom;

    /**
     * 分组信息集合
     */
    @Schema(description = "分组信息集合")
    private Map<SideEnum, List<PartWithFileInfoDTO>> partTotalMap;

    public void setPartTotalMap(@NonNull Map<SideEnum, List<PartWithFileInfoDTO>> partTotalMap) {
        this.partTotalMap = partTotalMap;
        // todo: 如果 SideEnum 有变化, 需要更改
        // 将map中的数据分发
        this.left = partTotalMap.get(SideEnum.LEFT);
        this.right = partTotalMap.get(SideEnum.RIGHT);
        this.bottom = partTotalMap.get(SideEnum.BOTTOM);
    }

    public void setPartTotalMapFromSideParts(@NonNull List<PartBySideDTO> partBySideDTOList) {
        // 将list数据转为map进行存储
        Map<SideEnum, List<PartWithFileInfoDTO>> map = new HashMap<>(SideEnum.values().length);
        for (PartBySideDTO part : partBySideDTOList) {
            map.put(part.getSide(), part.getParts().stream().map(item -> PartWithFileInfoDTO.builder().part(item).build()).collect(Collectors.toList()));
        }
        setPartTotalMap(map);
    }
}
