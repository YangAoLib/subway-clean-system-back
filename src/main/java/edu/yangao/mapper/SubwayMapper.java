package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.yangao.entity.Subway;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
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
}




