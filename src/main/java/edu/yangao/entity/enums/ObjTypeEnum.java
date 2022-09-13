package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 文件所属对象类型 枚举类
 * @create 2022-08-23 9:56
 */
@Getter
@AllArgsConstructor
@Schema(description = "文件所属对象类型 枚举类")
public enum ObjTypeEnum implements IEnum<Integer> {

    /**
     * 地铁车辆
     */
    SUBWAY_TYPE(0, "地铁车辆"),
    /**
     * 地铁车厢
     */
    SUBWAY_CARRIAGE(1, "地铁车厢"),
    /**
     * 零件
     */
    PART(2, "零件");

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
