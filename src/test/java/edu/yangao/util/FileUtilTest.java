package edu.yangao.util;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-18 9:17
 */
class FileUtilTest extends SubwayCleanSystemBackApplicationTest {

    @Test
    void uuidTest() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
