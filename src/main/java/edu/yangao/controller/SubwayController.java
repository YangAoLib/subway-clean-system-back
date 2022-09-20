package edu.yangao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.dto.SubwayFindConditionDTO;
import edu.yangao.entity.dto.SubwayMajorDTO;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.entity.vo.SubwayWithTypeInfoVO;
import edu.yangao.service.SubwayService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加车辆信息
     *
     * @param subwayMajorDTO 车辆信息
     * @return 添加情况
     */
    @PostMapping("/subway/save")
    @Operation(summary = "添加车辆信息")
    public Result<Boolean> saveSubway(@RequestBody @Validated SubwayMajorDTO subwayMajorDTO) {
        return Result.success(subwayService.saveSubway(subwayMajorDTO));
    }

    /**
     * 删除车辆信息
     *
     * @param id 车辆id
     * @return 删除情况
     */
    @DeleteMapping("/subway/delete/{id}")
    @Operation(summary = "删除车辆信息")
    public Result<Boolean> deleteSubway(@PathVariable("id") Integer id) {
        return Result.success(subwayService.removeById(id));
    }

    /**
     * 根据条件进行地铁信息的分页查询
     * @param conditionDTO 条件与分页大小
     * @return 分页后的地铁信息
     */
    @PostMapping("/subway/condition")
    @Operation(summary = "根据条件进行地铁信息的分页查询")
    public Result<IPage<SubwayWithTypeInfoVO>> selectSubwayWithTypeByCondition(@RequestBody @Validated SubwayFindConditionDTO conditionDTO) {
        return Result.success(subwayService.selectSubwayWithTypeInfo(conditionDTO));
    }

    @Autowired
    private SubwayService subwayService;

}
