package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 清理模式 枚举类
 * @create 2022-08-25 15:04
 */
@Getter
@AllArgsConstructor
@Schema(description = "清理模式 枚举类")
public enum PatternEnum implements IEnum<Integer> {

    /**
     * 简易清理
     */
    EASY_MODE(0, "简易清理"),
    /**
     * 深度清理
     */
    DEPTH_MODE(1, "深度清理");

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
