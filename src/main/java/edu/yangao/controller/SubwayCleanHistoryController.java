package edu.yangao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import edu.yangao.service.SubwayCleanHistoryService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangAo
 * @Description 地铁清理记录 控制类
 * @create 2022-08-25 15:53
 */
@RestController
@Tag(name = "地铁清理记录 控制类")
public class SubwayCleanHistoryController {

    /**
     * 添加地铁清理记录和对应的零件清理记录
     * @param subwayCleanAndPartCleanHistorySaveDTO 地铁id、清理模式、需要清理的零件id
     * @return 添加的地铁清理记录的 id
     */
    @PostMapping("/subway-clean-history/part-clean-history/save")
    @Operation(summary = "添加地铁清理记录和对应的零件清理记录")
    public Result<Integer> saveSubwayCleanAndPartCleanHistory(@RequestBody @Validated SubwayCleanAndPartCleanHistorySaveDTO subwayCleanAndPartCleanHistorySaveDTO) {
        return Result.success(subwayCleanHistoryService.saveSubwayCleanAndPartCleanHistory(subwayCleanAndPartCleanHistorySaveDTO));
    }

    /**
     * 根据条件进行清理记录及其清理零件信息
     * @param conditionDTO 条件信息(地铁名称、
     * @return 查询出来的结果
     */
    @PostMapping("/subway-clean-history/subway/parts")
    @Operation(summary = "根据条件进行清理记录及其清理零件信息")
    public Result<IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO>> selectAllWithSubwayAndPartsByCondition(@RequestBody @Validated SubwayCleanHistoryFindConditionDTO conditionDTO) {
        return Result.success(subwayCleanHistoryService.selectAllWithSubwayAndPartsByCondition(conditionDTO));
    }

    @Autowired
    private SubwayCleanHistoryService subwayCleanHistoryService;
}
