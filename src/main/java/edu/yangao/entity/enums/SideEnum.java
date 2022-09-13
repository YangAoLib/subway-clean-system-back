package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 零件所属面 枚举类
 * @create 2022-08-23 10:25
 */
@Getter
@AllArgsConstructor
@Schema(description = "零件所属面 枚举类")
public enum SideEnum implements IEnum<Integer> {

    /**
     * 车辆右侧
     */
    RIGHT(0, "车辆右侧"),
    /**
     * 车辆左侧
     */
    LEFT(1, "车辆左侧"),
    /**
     * 车辆底部
     */
    BOTTOM(2, "车辆底部");

    /**
     * 枚举值
     */
    @Schema(description = "枚举值")
    private final Integer value;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private final String description;
}
