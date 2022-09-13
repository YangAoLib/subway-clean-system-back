package edu.yangao.entity.dto;

import edu.yangao.entity.enums.FileTypeEnum;
import edu.yangao.entity.enums.ObjTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author YangAo
 * @Description 文件存储信息 主要属性 传输类
 * @create 2022-08-23 17:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "文件存储信息 主要属性 传输类")
public class FileInfoMajorDTO {

    /**
     * 文件id
     */
    @Min(1)
    @Schema(description = "文件id")
    private Integer id;

    /**
     * 文件描述
     */
    @Length(max = 50)
    @Schema(description = "文件描述")
    private String description;

    /**
     * 文件原名
     */
    @NotBlank
    @Length(max = 255)
    @Schema(description = "文件原名")
    private String originName;

    /**
     * 文件生成名
     */
    @NotBlank
    @Length(max = 255)
    @Schema(description = "文件生成名")
    private String currentName;

    /**
     * 文件类型(0-点云、1-图片、2-其他模型文件)
     */
    @NotNull
    @Schema(description = "文件类型(0-点云、1-图片、2-其他模型文件)")
    private FileTypeEnum fileType;

    /**
     * 文件存储路径
     */
    @NotBlank
    @Length(max = 255)
    @Schema(description = "文件存储路径")
    private String fileAddress;

    /**
     * 所属对象id
     */
    @NotNull
    @Min(1)
    @Schema(description = "所属对象id")
    private Integer objId;

    /**
     * 所属对象类型(0-车辆信息、1-车厢信息,2-零件信息)
     */
    @NotNull
    @Schema(description = "所属对象类型(0-车辆信息、1-车厢信息,2-零件信息)")
    private ObjTypeEnum objType;
}
