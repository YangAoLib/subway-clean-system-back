package edu.yangao.service;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangAo
 * @Description
 * @create 2022-08-25 17:55
 */
class PartServiceTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private PartService partService;

    @Test
    void getPartInfoWithFileGroupByCarriage() {
        System.out.println(partService.getPartInfoWithFileGroupByCarriage(1));
    }
}
