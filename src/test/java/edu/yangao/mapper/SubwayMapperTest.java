package edu.yangao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.dto.SubwayFindConditionDTO;
import edu.yangao.entity.vo.SubwayWithTypeInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    void selectSubwayWithTypeNameByCondition() {
        SubwayFindConditionDTO dto = SubwayFindConditionDTO.builder().pageSize(10).currentPage(1).name("测试地铁1").build();
        Page<SubwayWithTypeInfoVO> page = new Page<>(dto.getCurrentPage(), dto.getPageSize());
        System.out.println(subwayMapper.selectSubwayWithTypeNameByCondition(page, dto).getRecords());
    }
}
