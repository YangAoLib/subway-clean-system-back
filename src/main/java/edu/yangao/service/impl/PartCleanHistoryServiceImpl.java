package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.PartCleanHistory;
import edu.yangao.entity.dto.PartCleanHistoryUpdateDTO;
import edu.yangao.service.PartCleanHistoryService;
import edu.yangao.mapper.PartCleanHistoryMapper;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.ResultCode;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author YangAo
* @description 针对表【part_clean_history(零件清理历史记录)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:59
*/
@Service
public class PartCleanHistoryServiceImpl extends ServiceImpl<PartCleanHistoryMapper, PartCleanHistory>
    implements PartCleanHistoryService{

    @Override
    public Boolean updatePartCleanHistoryStatus(PartCleanHistoryUpdateDTO updateDTO) {
        // 参数校验
        // 状态参数错误
        if (Objects.isNull(updateDTO.getStatus())) {
            throw new CustomServiceException("请传入状态参数", ResultCode.PARAM_IS_INVALID);
        }
        // 确定记录是否存在
        Integer partId = updateDTO.getPartId();
        Integer cleanHistoryId = updateDTO.getCleanHistoryId();
        if (lambdaQuery().eq(PartCleanHistory::getPartId, partId).eq(PartCleanHistory::getCleanHistoryId, cleanHistoryId).list().size() != 1) {
            throw new CustomServiceException("无法确定零件清理记录或记录不存在", ResultCode.PARAM_IS_INVALID);
        }
        // 进行更新操作
        return lambdaUpdate().eq(PartCleanHistory::getPartId, partId).eq(PartCleanHistory::getCleanHistoryId, cleanHistoryId).update(PartCleanHistory.builder().status(updateDTO.getStatus()).build());
    }
}




