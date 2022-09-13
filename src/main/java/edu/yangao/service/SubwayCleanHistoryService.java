package edu.yangao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.SubwayCleanHistory;
import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;

/**
* @author YangAo
* @description 针对表【subway_clean_history(地铁清理历史记录)】的数据库操作Service
* @createDate 2022-08-22 17:49:59
*/
public interface SubwayCleanHistoryService extends IService<SubwayCleanHistory> {


    /**
     * 添加地铁清理记录和对应的零件清理记录
     * @param subwayCleanAndPartCleanHistorySaveDTO 添加所需的信息
     * @return 添加的地铁记录的id
     */
    Integer saveSubwayCleanAndPartCleanHistory(SubwayCleanAndPartCleanHistorySaveDTO subwayCleanAndPartCleanHistorySaveDTO);

}
