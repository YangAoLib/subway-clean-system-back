package edu.yangao.util;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-02 8:51
 */
public class ModbusUtilTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private ModbusUtil modbusUtil;

    @Test
    void modbusUtilAutowiredTest() {
        System.out.println(modbusUtil);
        System.out.println(modbusUtil);
    }
}
