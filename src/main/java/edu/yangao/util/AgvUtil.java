package edu.yangao.util;

import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import edu.yangao.entity.AgvInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author YangAo
 * @Description agv 工具类
 * @create 2022-09-02 8:46
 */
@Component
public class AgvUtil {

    private final ModbusUtil modbusUtil;

    public AgvUtil(ModbusUtil modbusUtil) {
        this.modbusUtil = modbusUtil;
    }

    public AgvInfo getAgvInfo() throws ModbusTransportException, ErrorResponseException {
        return AgvInfo.builder()
                .onTheMove(operation(ReadValueOperationEnum.ON_THE_MOVE) > 0)
                .moveComplete(operation(ReadValueOperationEnum.MOVE_COMPLETE) > 0)
                .currentPosition(operation(ReadValueOperationEnum.CURRENT_POSITION))
                .lowPower(operation(ReadBitOperationEnum.LOW_POWER))
                .emergencyStop(operation(ReadBitOperationEnum.EMERGENCY_STOP))
                .obstacleSensing(operation(ReadBitOperationEnum.OBSTACLE_SENSING))
                .mechanicalTouchSensing(operation(ReadBitOperationEnum.MECHANICAL_TOUCH_SENSING))
                .manualModeOrAutomaticMode(operation(ReadBitOperationEnum.MANUAL_MODE_OR_AUTOMATIC_MODE))
                .resetRequestManualIntervention(operation(ReadBitOperationEnum.RESET_REQUEST_MANUAL_INTERVENTION))
                .derailed(operation(ReadBitOperationEnum.DERAILED))
                .positionLost(operation(ReadBitOperationEnum.POSITION_LOST))
                .heading(operation(ReadValueOperationEnum.HEADING))
                .batteryTemperature(operation(ReadValueOperationEnum.BATTERY_TEMPERATURE))
                .batteryPower(operation(ReadValueOperationEnum.BATTERY_POWER)).build();

    }

    /**
     * 读取值
     *
     * @param operationEnum 要读取的数据
     * @return 读取到的值
     */
    public short operation(ReadValueOperationEnum operationEnum) throws ModbusTransportException, ErrorResponseException {
        return modbusUtil.readHoldingRegister(operationEnum.getAddress());
    }

    /**
     * 读取bit
     *
     * @param operationEnum 要读取的数据类型
     * @return 读取到的值
     */
    public boolean operation(ReadBitOperationEnum operationEnum) throws ModbusTransportException, ErrorResponseException {
        return modbusUtil.readHoldingRegisterByBit(operationEnum.getAddress(), operationEnum.getBit());
    }

    /**
     * 写入操作
     *
     * @param operationEnum 操作的数据
     * @param value         值
     * @return 写入结果
     */
    public boolean operation(WriteValueOperationEnum operationEnum, short value) throws ModbusTransportException, ErrorResponseException {
        return modbusUtil.writeHoldingRegister(operationEnum.getAddress(), value);
    }

    /**
     * 读取值操作枚举类
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum ReadValueOperationEnum {

        /**
         * 收到移动指令, 执行中
         */
        ON_THE_MOVE(22, "收到移动指令, 执行中"),
        /**
         * 移动指令执行完成
         */
        MOVE_COMPLETE(23, "移动指令执行完成"),
        /**
         * 当前位置
         */
        CURRENT_POSITION(24, "当前位置"),
        /**
         * 航向角
         */
        HEADING(30, "航向角"),
        /**
         * 电池温度
         */
        BATTERY_TEMPERATURE(31, "电池温度"),
        /**
         * 电池电量
         */
        BATTERY_POWER(32, "电池电量");

        /**
         * 访问地址
         */
        private int address;
        /**
         * 操作说明
         */
        private String explain;
    }

    /**
     * 读取值操作枚举类
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum ReadBitOperationEnum {

        /**
         * 低电量
         */
        LOW_POWER(25, 4, "低电量"),
        /**
         * 紧急停止
         */
        EMERGENCY_STOP(25, 5, "紧急停止"),
        /**
         * 障碍物感应
         */
        OBSTACLE_SENSING(25, 6, "障碍物感应"),
        /**
         * 机械触边感应
         */
        MECHANICAL_TOUCH_SENSING(25, 7, "机械触边感应"),
        /**
         * 手动模式或自动模式
         */
        MANUAL_MODE_OR_AUTOMATIC_MODE(25, 9, "手动模式或自动模式"),
        /**
         * 复位请求人工干预
         */
        RESET_REQUEST_MANUAL_INTERVENTION(25, 12, "复位请求人工干预"),
        /**
         * 脱离轨道
         */
        DERAILED(25, 13, "脱离轨道"),
        /**
         * 位置丢失
         */
        POSITION_LOST(25, 14, "位置丢失");


        /**
         * 访问地址
         */
        private int address;
        /**
         * 要访问的bit位
         */
        private int bit;
        /**
         * 操作说明
         */
        private String explain;
    }

    /**
     * 写入值操作枚举类
     */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum WriteValueOperationEnum {

        /**
         * 移动指令触发
         */
        MOVE(3, "移动指令触发"),
        /**
         * 绝对位置
         */
        ABSOLUTE_POSITION(4, "绝对位置"),
        /**
         * 移动中停车指令触发
         */
        STOP(5, "移动中停车指令触发"),
        /**
         * AGV最大移动速度
         */
        SPEED(6, "AGV最大移动速度"),
        /**
         * 低电量阈值
         */
        LOW_BATTERY_THRESHOLD(7, "低电量阈值"),
        /**
         * 中电量阈值
         */
        MEDIUM_BATTERY_THRESHOLD(8, "中电量阈值"),
        /**
         * 高电量阈值
         */
        HIGH_BATTERY_THRESHOLD(9, "高电量阈值");

        /**
         * 访问地址
         */
        private int address;
        /**
         * 操作说明
         */
        private String explain;
    }

}
