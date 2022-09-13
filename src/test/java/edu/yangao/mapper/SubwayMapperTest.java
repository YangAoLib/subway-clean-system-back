package edu.yangao.mapper;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangAo
 * @Description
 * @create 2022-08-24 10:42
 */
class SubwayMapperTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private SubwayMapper subwayMapper;

    @Test
    void selectSubWayAndTypeAndCarriage() {
        System.out.println(subwayMapper.selectSubWayAndTypeAndCarriage(1));
    }
}
