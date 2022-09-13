package edu.yangao.controller;

import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.service.SubwayService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangAo
 * @Description 地铁 控制类
 * @create 2022-08-24 15:15
 */
@RestController
@Tag(name = "地铁 控制类")
public class SubwayController {

    @GetMapping("/subway/info/type/carriage")
    @Operation(summary = "根据地铁名称获取 地铁信息、地铁类型、地铁车厢及对应文件信息")
    public Result<SubwayWithTypeAndCarriageInfoVO> getAllTypesOfFilesByObjIdAndObjType(@RequestParam String subwayName) {
        return Result.success(subwayService.getSubwayInfoAndTypeAndCarriage(subwayName));
    }

    @Autowired
    private SubwayService subwayService;

}
