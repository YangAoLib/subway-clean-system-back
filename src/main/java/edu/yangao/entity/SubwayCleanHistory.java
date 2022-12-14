package edu.yangao.entity;

import com.baomidou.mybatisplus.annotation.*;
import edu.yangao.entity.enums.CleanStateEnum;
import edu.yangao.entity.enums.DeletedEnum;
import edu.yangao.entity.enums.PatternEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 地铁清理历史记录
 *
 * @author YangAo
 * @TableName subway_clean_history
 */
@TableName(value = "subway_clean_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "地铁清理历史记录")
public class SubwayCleanHistory implements Serializable {
    /**
     * 地铁清理记录id
     */
    @TableId(type = IdType.AUTO)
    @Min(1)
    @Schema(description = "地铁清理记录id")
    private Integer id;

    /**
     * 清理的地铁id
     */
    @NotNull
    @Min(1)
    @Schema(description = "清理的地铁id")
    private Integer subwayId;

    /**
     * 清理模式(0-简易清理、深度清理)
     */
    @NotNull
    @Schema(description = "清理模式(0-简易清理、深度清理)")
    private PatternEnum pattern;


    /**
     * 清理状态(0-进行中(默认)、1-完成、2-终止)
     */
    @NotNull
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "清理状态(0-进行中(默认)、1-完成、2-终止)")
    private CleanStateEnum status;

    /**
     * 清理进度
     */
    @Range(max = 100)
    @Schema(description = "清理进度")
    private Integer cleanProgress;

    /**
     * 清理开始时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "清理开始时间")
    private Date createTime;

    /**
     * 清理结束时间
     */
    @Schema(description = "清理结束时间")
    private Date endTime;

    /**
     * 逻辑删除位: 0-未删除, 1-已删除
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "逻辑删除位: 0-未删除, 1-已删除")
    private DeletedEnum deleted;

    /**
     * 处理人
     */
    @Length(max = 20)
    @Schema(description = "处理人")
    private String handler;

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
        SubwayCleanHistory other = (SubwayCleanHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSubwayId() == null ? other.getSubwayId() == null : this.getSubwayId().equals(other.getSubwayId()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCleanProgress() == null ? other.getCleanProgress() == null : this.getCleanProgress().equals(other.getCleanProgress()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
                && (this.getHandler() == null ? other.getHandler() == null : this.getHandler().equals(other.getHandler()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubwayId() == null) ? 0 : getSubwayId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCleanProgress() == null) ? 0 : getCleanProgress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getHandler() == null) ? 0 : getHandler().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", subwayId=").append(subwayId);
        sb.append(", status=").append(status);
        sb.append(", cleanProgress=").append(cleanProgress);
        sb.append(", createTime=").append(createTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", handler=").append(handler);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
