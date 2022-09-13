package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 清理状态 枚举类
 * @create 2022-08-23 13:07
 */
@Getter
@AllArgsConstructor
@Schema(description = "清理状态 枚举类")
public enum CleanStateEnum implements IEnum<Integer> {

    /**
     * 未开始
     */
    NOT_STARTED(0, "未开始"),
    /**
     * 完成
     */
    COMPLETE(1, "完成"),
    /**
     * 终止
     */
    TERMINATE(2, "终止");

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
