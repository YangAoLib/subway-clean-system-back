package edu.yangao.controller;

import edu.yangao.entity.dto.PartCleanHistoryUpdateDTO;
import edu.yangao.service.PartCleanHistoryService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangAo
 * @Description 零件清理记录 控制类
 * @create 2022-09-16 16:56
 */
@RestController
@Tag(name = "零件清理记录 控制类")
public class PartCleanHistoryController {

    /**
     * 根据零件id与地铁清理记录id进行 零件清理记录状态的变更
     * @param updateDTO 更新所需信息
     * @return 更新情况
     */
    @PostMapping("/part-clean-history/update")
    @Operation(summary = "根据零件id与地铁清理记录id进行 零件清理记录状态的变更")
    public Result<Boolean> updatePartCleanHistoryStatus(@RequestBody PartCleanHistoryUpdateDTO updateDTO) {
        return Result.success(partCleanHistoryService.updatePartCleanHistoryStatus(updateDTO));
    }


    @Autowired
    private PartCleanHistoryService partCleanHistoryService;
}
