package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-15 22:05
 */
class SubwayCleanHistoryMapperTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private SubwayCleanHistoryMapper mapper;

    @Test
    void selectAllWithSubwayAndPartsByCondition() {
        IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO> page = new Page<>(1, 10);
        SubwayCleanHistoryFindConditionDTO dto = SubwayCleanHistoryFindConditionDTO.builder().subwayName("测试地铁1").build();
        System.out.println(mapper.selectAllWithSubwayAndPartsByCondition(page, dto).getRecords());
    }
}
