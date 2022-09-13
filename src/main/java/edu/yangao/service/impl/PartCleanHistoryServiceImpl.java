package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.PartCleanHistory;
import edu.yangao.service.PartCleanHistoryService;
import edu.yangao.mapper.PartCleanHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author YangAo
* @description 针对表【part_clean_history(零件清理历史记录)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:59
*/
@Service
public class PartCleanHistoryServiceImpl extends ServiceImpl<PartCleanHistoryMapper, PartCleanHistory>
    implements PartCleanHistoryService{

}




