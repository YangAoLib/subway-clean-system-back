package edu.yangao.util;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author YangAo
 * @Description modbus 工具类
 * @create 2022-09-02 8:46
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("modbus")
public class ModbusUtil {


    /**
     * 获取单例 master
     * @return 连接好的 ModbusMaster
     */
    public ModbusMaster getMaster() {
        // 单例
        if (Objects.nonNull(master) && master.isInitialized()) {
            return master;
        }
        // 设置参数并初始化master
        IpParameters ipParameters = new IpParameters();
        ipParameters.setHost(ip);
        ipParameters.setPort(port);
        master = new ModbusFactory().createTcpMaster(ipParameters, true);
        try {
            master.init();
        } catch (ModbusInitException e) {
            throw new CustomServiceException("modbus 连接初始化错误", ResultCode.SYSTEM_ERROR);
        }
        return master;
    }

    /**
     * 读保持寄存器
     * @param slaveId 从机id
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @return 读取值
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public short readHoldingRegister(int slaveId, int address) throws ModbusTransportException, ErrorResponseException {
        BaseLocator<Number> locator = BaseLocator.holdingRegister(slaveId, address, DataType.TWO_BYTE_INT_SIGNED);
        return getMaster().getValue(locator).shortValue();
    }


    /**
     * 读保持寄存器
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @return 读取值
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public short readHoldingRegister(int address) throws ModbusTransportException, ErrorResponseException {
        return readHoldingRegister(slaveId, address);
    }

    /**
     * 按位读保持寄存器
     * @param slaveId 从机id
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @param bit 要读取第几位bit
     * @return 读取值
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public boolean readHoldingRegisterByBit(int slaveId, int address, int bit) throws ModbusTransportException, ErrorResponseException {
        BaseLocator<Boolean> locator = BaseLocator.holdingRegisterBit(slaveId, address, bit);
        return getMaster().getValue(locator);
    }

    /**
     * 按位读保持寄存器
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @param bit 要读取第几位bit
     * @return 读取值
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public boolean readHoldingRegisterByBit(int address, int bit) throws ModbusTransportException, ErrorResponseException {
        return readHoldingRegisterByBit(slaveId, address, bit);
    }

    /**
     * 写保持寄存器
     * @param slaveId 从机id
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @param value 写入值
     * @return 是否写入成功
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public boolean writeHoldingRegister(int slaveId, int address, short value) throws ModbusTransportException, ErrorResponseException {
        BaseLocator<Number> locator = BaseLocator.holdingRegister(slaveId, address, DataType.TWO_BYTE_INT_SIGNED);
        try {
            getMaster().setValue(locator, value);
        } catch (ModbusTransportException | ErrorResponseException e) {
            return false;
        }
        return true;
    }

    /**
     * 写保持寄存器
     * @param address 寄存器地址(40001+ 或者 从1开始)
     * @param value 写入值
     * @return 是否写入成功
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     */
    public boolean writeHoldingRegister(int address, short value) throws ModbusTransportException, ErrorResponseException {
        return writeHoldingRegister(slaveId, address, value);
    }

    // todo: 其他功能 本项目预计不会使用到
    // 读线圈
    // 读离散输入量
    // 读输入寄存器
    // 写线圈

    /**
     * 从机连接
     */
    private static ModbusMaster master;

    /**
     * 地址 默认本地
     */
    private String ip = "localhost";
    /**
     * 端口 默认502
     */
    private Integer port = 502;
    /**
     * 从机id 默认1
     */
    private Integer slaveId = 1;
}
