package edu.yangao.service;

import edu.yangao.entity.PartCleanHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.dto.PartCleanHistoryUpdateDTO;

/**
* @author YangAo
* @description 针对表【part_clean_history(零件清理历史记录)】的数据库操作Service
* @createDate 2022-08-22 17:49:59
*/
public interface PartCleanHistoryService extends IService<PartCleanHistory> {

    /**
     * 更新零件清理记录的状态
     * @param updateDTO 更新信息(零件id, 清理记录id, 清理状态)
     * @return 更新情况
     */
    Boolean updatePartCleanHistoryStatus(PartCleanHistoryUpdateDTO updateDTO);

}
