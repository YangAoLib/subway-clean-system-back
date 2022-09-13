package edu.yangao.service.impl;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.service.SubwayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangAo
 * @Description
 * @create 2022-08-24 15:06
 */
class SubwayServiceImplTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private SubwayService subwayService;

    @Test
    void getSubwayInfoAndTypeAndCarriage() {
        SubwayWithTypeAndCarriageInfoVO infoVO = subwayService.getSubwayInfoAndTypeAndCarriage(2);
        System.out.println(infoVO);
    }
}
