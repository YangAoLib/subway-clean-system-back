package edu.yangao.controller;

import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;
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

    @Autowired
    private SubwayCleanHistoryService subwayCleanHistoryService;
}
