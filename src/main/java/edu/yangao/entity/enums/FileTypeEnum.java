package edu.yangao.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YangAo
 * @Description 文件类型 枚举类
 * @create 2022-08-23 9:49
 */
@Getter
@AllArgsConstructor
@Schema(description = "文件类型 枚举类")
public enum FileTypeEnum implements IEnum<Integer> {

    /**
     * 点云模型
     */
    POINT_CLOUD(0, "点云模型"),
    /**
     * 图片文件
     */
    PICTURE(1, "图片文件"),
    /**
     * 其他文件
     */
    OTHER_FILE(2, "其他文件");

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
