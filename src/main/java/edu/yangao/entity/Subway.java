package edu.yangao.entity;

import com.baomidou.mybatisplus.annotation.*;
import edu.yangao.entity.enums.DeletedEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 地铁信息数据
 *
 * @author YangAo
 * @TableName subway
 */
@TableName(value = "subway")
@Data
@Builder
@Schema(description = "地铁信息数据")
public class Subway implements Serializable {
    /**
     * 地铁id
     */
    @TableId(type = IdType.AUTO)
    @Min(1)
    @Schema(description = "地铁编号")
    private Integer id;

    /**
     * 地铁名
     */
    @NotBlank
    @Length(max = 8)
    @Schema(description = "地铁名")
    private String name;

    /**
     * 地铁型号id
     */
    @NotNull
    @Min(1)
    @Schema(description = "地铁型号id")
    private Integer subwayTypeId;

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
    @TableField(fill = FieldFill.INSERT)
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
        Subway other = (Subway) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getSubwayTypeId() == null ? other.getSubwayTypeId() == null : this.getSubwayTypeId().equals(other.getSubwayTypeId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSubwayTypeId() == null) ? 0 : getSubwayTypeId().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", subwayTypeId=").append(subwayTypeId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
