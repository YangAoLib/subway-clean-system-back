package edu.yangao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryUpdateStatusDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartGroupByCarriageVO;
import edu.yangao.service.SubwayCleanHistoryService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     *
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
     *
     * @param conditionDTO 条件信息(地铁名称、
     * @return 查询出来的结果
     */
    @PostMapping("/subway-clean-history/subway/parts")
    @Operation(summary = "根据条件进行清理记录及其清理零件信息")
    public Result<IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO>> selectAllWithSubwayAndPartsByCondition(@RequestBody @Validated SubwayCleanHistoryFindConditionDTO conditionDTO) {
        return Result.success(subwayCleanHistoryService.selectAllWithSubwayAndPartsByCondition(conditionDTO));
    }

    /**
     * 根据 地铁清理记录id 查询 其记录与相关零件信息
     *
     * @param subwayCleanHistoryId 地铁清理记录id
     * @return 包含地铁清理记录的基础信息(subwayCleanHistory) 和 零件信息
     */
    @GetMapping("/subway-clean-history/parts/{id}")
    @Operation(summary = "包含地铁清理记录的基础信息 和 零件信息")
    public Result<SubwayCleanHistoryWithPartGroupByCarriageVO> selectAllWithPartsGroupByCarriageByCleanHistoryId(@PathVariable("id") Integer subwayCleanHistoryId) {
        return Result.success(subwayCleanHistoryService.selectAllWithPartsGroupByCarriageByCleanHistoryId(subwayCleanHistoryId));
    }

    /**
     * 根据id进行地铁清理进度和状态的更新
     * @param updateStatusDTO 地铁记录id与清理进度 (也可直接更新状态)
     * @return 更新状态
     */
    @PostMapping("/subway-clean-history/update/progress")
    @Operation(summary = "根据id进行地铁清理进度和状态的更新")
    public Result<Boolean> updateSubwayCleanHistoryStatus(@RequestBody @Validated  SubwayCleanHistoryUpdateStatusDTO updateStatusDTO) {
        return Result.success(subwayCleanHistoryService.updateSubwayCleanHistoryStatus(updateStatusDTO));
    }

    @Autowired
    private SubwayCleanHistoryService subwayCleanHistoryService;
}
