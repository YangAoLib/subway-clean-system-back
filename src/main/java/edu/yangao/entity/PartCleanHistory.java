package edu.yangao.entity;

import com.baomidou.mybatisplus.annotation.*;
import edu.yangao.entity.enums.CleanStateEnum;
import edu.yangao.entity.enums.DeletedEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 零件清理历史记录
 *
 * @author YangAo
 * @TableName part_clean_history
 */
@TableName(value = "part_clean_history")
@Data
@Builder
@Schema(description = "零件清理历史记录")
public class PartCleanHistory implements Serializable {
    /**
     * 零件清理记录id
     */
    @TableId(type = IdType.AUTO)
    @Min(1)
    @Schema(description = "零件清理记录id")
    private Integer id;

    /**
     * 被清理的零件id
     */
    @NotNull
    @Min(1)
    @Schema(description = "被清理的零件id")
    private Integer partId;

    /**
     * 清理状态(0-未开始(默认)、1-完成、2-终止)
     */
    @TableField(fill = FieldFill.INSERT)
    @NotNull
    @Schema(description = "清理状态(0-进行中(默认)、1-完成、2-终止)")
    private CleanStateEnum status;

    /**
     * 地铁清理历史记录id
     */
    @NotNull
    @Min(1)
    @Schema(description = "地铁清理历史记录id")
    private Integer cleanHistoryId;

    /**
     * 清理开始的时间
     */
    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "清理开始的时间")
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
        PartCleanHistory other = (PartCleanHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPartId() == null ? other.getPartId() == null : this.getPartId().equals(other.getPartId()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCleanHistoryId() == null ? other.getCleanHistoryId() == null : this.getCleanHistoryId().equals(other.getCleanHistoryId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartId() == null) ? 0 : getPartId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCleanHistoryId() == null) ? 0 : getCleanHistoryId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", partId=").append(partId);
        sb.append(", status=").append(status);
        sb.append(", cleanHistoryId=").append(cleanHistoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
