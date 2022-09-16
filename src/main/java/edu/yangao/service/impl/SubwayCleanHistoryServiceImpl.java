package edu.yangao.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import edu.yangao.entity.Part;
import edu.yangao.entity.PartCleanHistory;
import edu.yangao.entity.Subway;
import edu.yangao.entity.SubwayCleanHistory;
import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryMajorDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartGroupByCarriageVO;
import edu.yangao.mapper.PartMapper;
import edu.yangao.mapper.SubwayCleanHistoryMapper;
import edu.yangao.mapper.SubwayMapper;
import edu.yangao.service.PartCleanHistoryService;
import edu.yangao.service.SubwayCleanHistoryService;
import edu.yangao.util.BeanUtil;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author YangAo
* @description 针对表【subway_clean_history(地铁清理历史记录)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:59
*/
@Service
public class SubwayCleanHistoryServiceImpl extends ServiceImpl<SubwayCleanHistoryMapper, SubwayCleanHistory>
    implements SubwayCleanHistoryService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveSubwayCleanAndPartCleanHistory(SubwayCleanAndPartCleanHistorySaveDTO subwayCleanAndPartCleanHistorySaveDTO) {
        // 校验地铁车辆是否存在
        Integer subwayId = subwayCleanAndPartCleanHistorySaveDTO.getSubwayId();
        if (Objects.isNull(subwayId) || subwayId <= 0) {
            throw new CustomServiceException("未接受到正确的地铁id", ResultCode.PARAM_IS_INVALID);
        } else if (ChainWrappers.lambdaQueryChain(subwayMapper).eq(Subway::getId, subwayId).count() != 1) {
            throw new CustomServiceException("无对应地铁信息", ResultCode.PARAM_IS_INVALID);
        }
        // 校验零件是否都存在
        List<Integer> partIdList = subwayCleanAndPartCleanHistorySaveDTO.getPartIdList();
        // 用于记录查询出来的数据的数量
        Long count = 0L;
        if (CollectionUtils.isEmpty(partIdList)) {
            throw new CustomServiceException("未接受到需要进行清理的零件", ResultCode.PARAM_IS_INVALID);
        } else if ((count = ChainWrappers.lambdaQueryChain(partMapper).in(Part::getId, partIdList).count()) < partIdList.size()){
            throw new CustomServiceException("零件id信息错误, 有部分id无对应的零件", ResultCode.PARAM_IS_INVALID);
        } else if (count > partIdList.size()){
            throw new CustomServiceException("有关零件id列表的未知错误", ResultCode.PARAM_IS_INVALID);
        }
        // 插入 地铁清理记录
        SubwayCleanHistory subwayCleanHistory = SubwayCleanHistory.builder().subwayId(subwayId).pattern(subwayCleanAndPartCleanHistorySaveDTO.getPattern()).cleanProgress(0).build();
        baseMapper.insert(subwayCleanHistory);
        Integer subwayCleanHistoryId = subwayCleanHistory.getId();
        // 插入 零件清理记录
        partCleanHistoryService.saveBatch(partIdList.stream().map(partId -> PartCleanHistory.builder().partId(partId).cleanHistoryId(subwayCleanHistoryId).build()).collect(Collectors.toList()));
        return subwayCleanHistoryId;
    }

    @Override
    public IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO> selectAllWithSubwayAndPartsByCondition(SubwayCleanHistoryFindConditionDTO conditionDTO) {
        Integer currentPage = conditionDTO.getCurrentPage();
        Integer pageSize = conditionDTO.getPageSize();
        // 数据校验
        if (currentPage == null || currentPage <= 0 || pageSize == null || pageSize <= 0) {
            throw new CustomServiceException("分页参数错误", ResultCode.PARAM_IS_INVALID);
        }
        Date timeStart = conditionDTO.getCreateTimeStart();
        Date timeEnd = conditionDTO.getCreateTimeEnd();
        if ((timeStart != null || timeEnd != null) && timeEnd.getTime() >= timeEnd.getTime()) {
            throw new CustomServiceException("时间参数错误", ResultCode.PARAM_IS_INVALID);
        }
        //执行查找
        Page<SubwayCleanHistoryWithPartAndSubwayInfoVO> page = new Page<>(currentPage, pageSize);
        return baseMapper.selectAllWithSubwayAndPartsByCondition(page, conditionDTO);
    }

    @Override
    public SubwayCleanHistoryWithPartGroupByCarriageVO selectAllWithPartsGroupByCarriageByCleanHistoryId(Integer subwayCleanHistoryId) {
        return SubwayCleanHistoryWithPartGroupByCarriageVO.builder().subwayCleanHistory(BeanUtil.copyBean(baseMapper.selectById(subwayCleanHistoryId), SubwayCleanHistoryMajorDTO.class)).parts(partMapper.selectAllBySubwayCleanHistoryId(subwayCleanHistoryId)).build();
    }


    @Autowired
    private SubwayMapper subwayMapper;
    @Autowired
    private PartMapper partMapper;
    @Autowired
    private PartCleanHistoryService partCleanHistoryService;
}




