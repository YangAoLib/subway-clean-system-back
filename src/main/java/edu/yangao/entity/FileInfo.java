package edu.yangao.entity;

import com.baomidou.mybatisplus.annotation.*;
import edu.yangao.entity.enums.DeletedEnum;
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
import java.io.Serializable;
import java.util.Date;

/**
 * 文件存储信息
 * @author YangAo
 * @TableName file_info
 */
@TableName(value ="file_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "文件存储信息")
public class FileInfo implements Serializable {
    /**
     * 文件id
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "更新时间")
    private Date updateTime;

    /**
     * 逻辑删除位: 0-未删除, 1-已删除
     */
    @TableField(fill = FieldFill.UPDATE)
    @Schema(description = "逻辑删除位: 0-未删除, 1-已删除")
    private DeletedEnum deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileInfo other = (FileInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getOriginName() == null ? other.getOriginName() == null : this.getOriginName().equals(other.getOriginName()))
            && (this.getCurrentName() == null ? other.getCurrentName() == null : this.getCurrentName().equals(other.getCurrentName()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getFileAddress() == null ? other.getFileAddress() == null : this.getFileAddress().equals(other.getFileAddress()))
            && (this.getObjId() == null ? other.getObjId() == null : this.getObjId().equals(other.getObjId()))
            && (this.getObjType() == null ? other.getObjType() == null : this.getObjType().equals(other.getObjType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getOriginName() == null) ? 0 : getOriginName().hashCode());
        result = prime * result + ((getCurrentName() == null) ? 0 : getCurrentName().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileAddress() == null) ? 0 : getFileAddress().hashCode());
        result = prime * result + ((getObjId() == null) ? 0 : getObjId().hashCode());
        result = prime * result + ((getObjType() == null) ? 0 : getObjType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", originName=").append(originName);
        sb.append(", currentName=").append(currentName);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileAddress=").append(fileAddress);
        sb.append(", objId=").append(objId);
        sb.append(", objType=").append(objType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
