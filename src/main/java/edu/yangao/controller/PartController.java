package edu.yangao.controller;

import edu.yangao.entity.dto.PartWithFileInfoDTO;
import edu.yangao.entity.vo.PartGroupWithFileVO;
import edu.yangao.service.PartService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author YangAo
 * @Description 零件 控制类
 * @create 2022-08-25 10:45
 */
@RestController
@Tag(name = "零件 控制类")
public class PartController {

    @GetMapping("/part/file")
    @Operation(summary = "根据地铁车厢名称查询零件信息携带文件信息")
    public Result<PartGroupWithFileVO> getPartInfoWithFileGroup(@RequestParam String subwayCarriageName) {
        return Result.success(partService.getPartInfoWithFileGroup(subwayCarriageName));
    }

    @GetMapping("/part/file/group/carriage")
    @Operation(summary = "根据地铁清理记录id 获取 根据车厢分组的零件信息")
    public Result<Map<String, List<PartWithFileInfoDTO>>> getPartInfoWithFileGroupByCarriage(@RequestParam Integer subwayCleanHistoryId) {
        return Result.success(partService.getPartInfoWithFileGroupByCarriage(subwayCleanHistoryId));
    }

    @Autowired
    private PartService partService;

}
