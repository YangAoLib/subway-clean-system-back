package edu.yangao.mapper;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.Part;
import edu.yangao.entity.enums.SideEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author YangAo
 * @Description mapper 测试类
 * @create 2022-08-23 10:43
 */
public class MapperTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private PartMapper partMapper;

    @Test
    public void partMapperInsertTest() {
        Part part = Part.builder().name("测试零件").side(SideEnum.LEFT).position("{\"x\": 50, \"y\": 50}").threePosition("{\"x\": \"50\", \"y\": \"30\", \"z\": \"30\"}").description("一车型|二车厢|测试零件").subwayCarriageId(2).build();
        System.out.println(partMapper.insert(part));
    }
}
