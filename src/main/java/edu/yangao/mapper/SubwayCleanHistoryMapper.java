package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.SubwayCleanHistory;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author YangAo
* @description 针对表【subway_clean_history(地铁清理历史记录)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.SubwayCleanHistory
*/
@Mapper
public interface SubwayCleanHistoryMapper extends BaseMapper<SubwayCleanHistory> {

    /**
     * 根据条件查询(分页) 地铁清理记录(携带其对应清理的零件信息)
     * @param condition 条件
     * @return
     */
    IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO> selectAllWithSubwayAndPartsByCondition(IPage<?> page, @Param("condition") SubwayCleanHistoryFindConditionDTO condition);

}




