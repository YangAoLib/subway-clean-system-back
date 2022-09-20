package edu.yangao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.yangao.entity.Subway;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.dto.SubwayFindConditionDTO;
import edu.yangao.entity.dto.SubwayMajorDTO;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.entity.vo.SubwayWithTypeInfoVO;

/**
* @author YangAo
* @description 针对表【subway(地铁信息数据)】的数据库操作Service
* @createDate 2022-08-22 17:49:59
*/
public interface SubwayService extends IService<Subway> {

    /**
     * 根据地铁名称获取 地铁信息、地铁类型、地铁车厢及对应文件信息
     * @param subwayName 地铁名称
     * @return 地铁信息、地铁类型、地铁车厢及对应文件信息
     */
    SubwayWithTypeAndCarriageInfoVO getSubwayInfoAndTypeAndCarriage(String subwayName);

    /**
     * 根据地铁id获取 地铁信息、地铁类型、地铁车厢及对应文件信息
     * @param subwayId 地铁id
     * @return 地铁信息、地铁类型、地铁车厢及对应文件信息
     */
    SubwayWithTypeAndCarriageInfoVO getSubwayInfoAndTypeAndCarriage(Integer subwayId);

    /**
     * 添加地铁车辆信息
     * @param subwayMajorDTO 地铁基础信息
     * @return 添加情况
     */
    Boolean saveSubway(SubwayMajorDTO subwayMajorDTO);

    /**
     * 根据条件 按分页进行 地铁信息的查找
     * @param conditionDTO 查询条件
     * @return 分页后的数据
     */
    IPage<SubwayWithTypeInfoVO> selectSubwayWithTypeInfo(SubwayFindConditionDTO conditionDTO);
}
