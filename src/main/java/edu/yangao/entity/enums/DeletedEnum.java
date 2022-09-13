package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 删除 枚举类
 * @create 2022-08-22 17:21
 */
@Getter
@AllArgsConstructor
@Schema(description = "删除 枚举类")
public enum DeletedEnum implements IEnum<Integer> {

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),
    /**
     * 已删除
     */
    DELETED(1, "已删除");


    /**
     * 枚举值, 会存入数据库
     */
    @Schema(description = "枚举值")
    private final Integer value;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private final String description;
}
