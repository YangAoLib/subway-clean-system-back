package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.Subway;
import edu.yangao.entity.dto.SubwayFindConditionDTO;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.entity.vo.SubwayWithTypeInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author YangAo
* @description 针对表【subway(地铁信息数据)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.Subway
*/
@Mapper
public interface SubwayMapper extends BaseMapper<Subway> {

    /**
     * 根据地铁id获取 地铁信息、地铁类型信息、地铁车厢及对应文件
     * @param subwayId 地铁id
     * @return 地铁信息、地铁类型信息、地铁车厢及对应文件
     */
    SubwayWithTypeAndCarriageInfoVO selectSubWayAndTypeAndCarriage(@Param("id") Integer subwayId);

    /**
     * 根据条件进行地铁信息的查找 分页
     * @param page 分页操作
     * @param conditionDTO 条件信息 (名称、创建时间区间、车型名称、分页信息)
     * @return 查询出的已分页的信息
     */
    IPage<SubwayWithTypeInfoVO> selectSubwayWithTypeNameByCondition(IPage<?> page, @Param("condition") SubwayFindConditionDTO conditionDTO);
}




