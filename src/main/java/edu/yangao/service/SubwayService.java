package edu.yangao.service;

import edu.yangao.entity.Subway;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;

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
}
