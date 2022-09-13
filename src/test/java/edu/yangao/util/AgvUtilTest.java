package edu.yangao.util;

import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import edu.yangao.SubwayCleanSystemBackApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-04 0:44
 */
class AgvUtilTest extends SubwayCleanSystemBackApplicationTest {
    @Autowired
    private AgvUtil agvUtil;

    @Test
    void getAgvInfo() throws ModbusTransportException, ErrorResponseException {
        System.out.println(agvUtil.getAgvInfo());
    }
}
