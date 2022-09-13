package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.Subway;
import edu.yangao.entity.dto.FileInfoMajorDTO;
import edu.yangao.entity.dto.SubwayCarriageWithFileInfoDTO;
import edu.yangao.entity.enums.ObjTypeEnum;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.mapper.SubwayMapper;
import edu.yangao.service.FileInfoService;
import edu.yangao.service.SubwayService;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
* @author YangAo
* @description 针对表【subway(地铁信息数据)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:59
*/
@Service
public class SubwayServiceImpl extends ServiceImpl<SubwayMapper, Subway>
    implements SubwayService{

    @Override
    public SubwayWithTypeAndCarriageInfoVO getSubwayInfoAndTypeAndCarriage(String subwayName) {
        List<Subway> subways = lambdaQuery().eq(Subway::getName, subwayName).list();
        // 校验地铁名的正确性
        if (subways.size() == 0) {
            throw new CustomServiceException("该名称无法查询到对应的地铁", ResultCode.PARAM_IS_INVALID);
        } else if (subways.size() > 1) {
            throw new CustomServiceException("该名称有多个对应地铁, 无法查询", ResultCode.PARAM_IS_INVALID);
        }
        return getSubwayInfoAndTypeAndCarriage(subways.get(0).getId());
    }

    @Override
    public SubwayWithTypeAndCarriageInfoVO getSubwayInfoAndTypeAndCarriage(Integer subwayId) {
        // id校验
        if (Objects.isNull(subwayId) || subwayId <= 0 || CollectionUtils.isEmpty(lambdaQuery().eq(Subway::getId, subwayId).list())) {
            throw new CustomServiceException("该地铁不存在", ResultCode.PARAM_IS_INVALID);
        }
        // 获取除文件信息外的其他信息
        SubwayWithTypeAndCarriageInfoVO infoVO = baseMapper.selectSubWayAndTypeAndCarriage(subwayId);
        // 获取文件信息
        for (SubwayCarriageWithFileInfoDTO item : infoVO.getSubwayCarriageWithFileInfoList()) {
            item.setFileTotalInfoMap(fileInfoService.getAllTypesOfFilesByObjIdAndObjType(item.getSubwayCarriage().getId(), ObjTypeEnum.SUBWAY_CARRIAGE, FileInfoMajorDTO.class));
        }
        // 设置车厢数量
        infoVO.setSubwayCarriageCount(infoVO.getSubwayCarriageWithFileInfoList().size());
        return infoVO;
    }

    @Autowired
    private FileInfoService fileInfoService;
}




