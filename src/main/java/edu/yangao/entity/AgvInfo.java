package edu.yangao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-03 23:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgvInfo {

    /**
     * 移动
     */
    private Boolean move;
    /**
     * 绝对位置
     */
    @Min(0)
    private Short absolutePosition;
    /**
     * 停止
     */
    private Boolean stop;
    /**
     * 速度
     */
    @Range(min = 10, max = 1000)
    private Short speed;
    /**
     * 低电量阈值
     */
    @Min(0)
    private Short lowBatteryThreshold;
    /**
     * 中电量阈值
     */
    @Min(1)
    private Short mediumBatteryThreshold;
    /**
     * 高电量阈值
     */
    @Min(1)
    private Short highBatteryThreshold;


    /**
     * 移动中
     */
    private Boolean onTheMove;
    /**
     * 移动完成
     */
    private Boolean moveComplete;
    /**
     * 当前位置
     */
    @Min(0)
    private Short currentPosition;
    /**
     * 低电量
     */
    private Boolean lowPower;
    /**
     * 紧急停止
     */
    private Boolean emergencyStop;
    /**
     * 障碍物感应
     */
    private Boolean obstacleSensing;
    /**
     * 机械触边感应
     */
    private Boolean mechanicalTouchSensing;
    /**
     * 手动模式或自动模式
     */
    private Boolean manualModeOrAutomaticMode;
    /**
     * 复位请求人工干预
     */
    private Boolean resetRequestManualIntervention;
    /**
     * 脱离轨道
     */
    private Boolean derailed;
    /**
     * 位置丢失
     */
    private Boolean positionLost;
    /**
     * 航向角
     */
    private Short heading;
    /**
     * 电池温度
     */
    private Short batteryTemperature;
    /**
     * 电池电量
     */
    @Range(min = 0, max = 100)
    private Short batteryPower;
}
