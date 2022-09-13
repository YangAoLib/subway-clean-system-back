package edu.yangao.entity;

import com.baomidou.mybatisplus.annotation.*;
import edu.yangao.entity.enums.DeletedEnum;
import edu.yangao.entity.enums.SideEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 零件信息
 *
 * @author YangAo
 * @TableName part
 */
@TableName(value = "part")
@Data
@Builder
@Schema(description = "零件信息")
public class Part implements Serializable {
    /**
     * 零件id
     */
    @TableId(type = IdType.AUTO)
    @Min(1)
    @Schema(description = "零件id")
    private Integer id;

    /**
     * 零件名称
     */
    @NotBlank
    @Length(max = 20)
    @Schema(description = "零件名称")
    private String name;

    /**
     * 零件所属面(0-右侧, 1-左侧, 2-底部)——零件是哪个面的
     */
    @NotNull
    @Schema(description = "零件所属面(0-右侧, 1-左侧, 2-底部)——零件是哪个面的")
    private SideEnum side;

    /**
     * 坐标 {"x":0, "y":0}
     * json格式字符串
     */
    @Pattern(regexp = "^\\{\"x\":\\d{1,3},\"y\":\\d{1,3}}", flags = Pattern.Flag.COMMENTS)
    @Schema(description = "坐标 {\"x\":0, \"y\":0} ——json格式字符串")
    private String position;

    /**
     * 三维坐标{"x":0, "y":0, "z": 0}
     * json格式字符串
     */
    @Pattern(regexp = "^\\{\"x\":\\d{1,3},\"y\":\\d{1,3},\"z\":\\d{1,3}}", flags = Pattern.Flag.COMMENTS)
    @Schema(description = "三维坐标{\"x\":0, \"y\":0, \"z\": 0}——json格式字符串")
    private String threePosition;

    /**
     * 具体描述(车型+车厢+零件名)
     */
    @NotBlank
    @Length(max = 60)
    @Schema(description = "具体描述(车型+车厢+零件名)")
    private String description;

    /**
     * 车厢id
     */
    @NotNull
    @Min(1)
    @Schema(description = "车厢id")
    private Integer subwayCarriageId;

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
        Part other = (Part) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getSide() == null ? other.getSide() == null : this.getSide().equals(other.getSide()))
                && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
                && (this.getThreePosition() == null ? other.getThreePosition() == null : this.getThreePosition().equals(other.getThreePosition()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getSubwayCarriageId() == null ? other.getSubwayCarriageId() == null : this.getSubwayCarriageId().equals(other.getSubwayCarriageId()))
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
        result = prime * result + ((getSide() == null) ? 0 : getSide().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getThreePosition() == null) ? 0 : getThreePosition().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getSubwayCarriageId() == null) ? 0 : getSubwayCarriageId().hashCode());
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
        sb.append(", side=").append(side);
        sb.append(", position=").append(position);
        sb.append(", threePosition=").append(threePosition);
        sb.append(", description=").append(description);
        sb.append(", subwayCarriageId=").append(subwayCarriageId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
