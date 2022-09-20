package edu.yangao.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.Subway;
import edu.yangao.entity.SubwayType;
import edu.yangao.entity.dto.FileInfoMajorDTO;
import edu.yangao.entity.dto.SubwayCarriageWithFileInfoDTO;
import edu.yangao.entity.dto.SubwayFindConditionDTO;
import edu.yangao.entity.dto.SubwayMajorDTO;
import edu.yangao.entity.enums.ObjTypeEnum;
import edu.yangao.entity.vo.SubwayWithTypeAndCarriageInfoVO;
import edu.yangao.entity.vo.SubwayWithTypeInfoVO;
import edu.yangao.mapper.SubwayMapper;
import edu.yangao.mapper.SubwayTypeMapper;
import edu.yangao.service.FileInfoService;
import edu.yangao.service.SubwayService;
import edu.yangao.util.BeanUtil;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author YangAo
 * @description 针对表【subway(地铁信息数据)】的数据库操作Service实现
 * @createDate 2022-08-22 17:49:59
 */
@Service
public class SubwayServiceImpl extends ServiceImpl<SubwayMapper, Subway>
        implements SubwayService {

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

    @Override
    public Boolean saveSubway(SubwayMajorDTO subwayMajorDTO) {
        // 检查车型是否存在
        List<SubwayType> subwayTypes = new LambdaQueryChainWrapper<SubwayType>(subwayTypeMapper).eq(SubwayType::getId, subwayMajorDTO.getSubwayTypeId()).list();
        if (CollectionUtils.isEmpty(subwayTypes)) {
            throw new CustomServiceException("所选车型不存在", ResultCode.PARAM_IS_INVALID);
        }
        if (subwayTypes.size() > 1) {
            throw new CustomServiceException("数据库错误, 请联系管理人员", ResultCode.SYSTEM_ERROR);
        }
        // 进行添加操作
        return save(BeanUtil.copyBean(subwayMajorDTO, Subway.class));
    }

    @Override
    public IPage<SubwayWithTypeInfoVO> selectSubwayWithTypeInfo(SubwayFindConditionDTO conditionDTO) {
        // 数据校验
        Date timeStart = conditionDTO.getCreateTimeStart();
        Date timeEnd = conditionDTO.getCreateTimeEnd();
        // 两个日期都存在, 并且结束小于起始
        if (Objects.nonNull(timeStart) && Objects.nonNull(timeEnd) && timeEnd.getTime() < timeStart.getTime() // 两个时间一个为空 一个不为空
                || Objects.nonNull(timeStart) ^ Objects.nonNull(timeEnd)) {
            throw new CustomServiceException("创建时间区间参数错误", ResultCode.PARAM_IS_INVALID);
        }
        return baseMapper.selectSubwayWithTypeNameByCondition(new Page<>(conditionDTO.getCurrentPage(), conditionDTO.getPageSize()), conditionDTO);
    }

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private SubwayTypeMapper subwayTypeMapper;
}




