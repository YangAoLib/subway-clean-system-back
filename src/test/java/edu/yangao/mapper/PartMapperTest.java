package edu.yangao.mapper;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.Part;
import edu.yangao.entity.enums.SideEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangAo
 * @Description
 * @create 2022-08-24 17:55
 */
class PartMapperTest extends SubwayCleanSystemBackApplicationTest {


    @Autowired
    private PartMapper partMapper;

    @Test
    void selectAllBySubwayCarriageId() {
        System.out.println(partMapper.selectAllBySubwayCarriageId(1));
    }

    @Test
    void insertTest() {
        Integer subwayCarriageId = 1;
        SideEnum[] sideEnums = SideEnum.values();
        int count = 10;
        for (int i = 0; i < count; ++i) {
            for (SideEnum sideEnum : sideEnums) {
                Part part = Part.builder()
                        .side(sideEnum)
                        .subwayCarriageId(subwayCarriageId)

                        .description("测试零件")
                        .name("测试零件")
                        .position("{\"x\": 50, \"y\": 50}")
                        .threePosition("{\"x\": 50, \"y\": 50, \"z\": 50}")
                        .build();
                partMapper.insert(part);
            }
        }
    }

    @Test
    void selectAllBySubwayCleanHistoryId() {

        System.out.println(partMapper.selectAllBySubwayCleanHistoryId(1));
    }
}
