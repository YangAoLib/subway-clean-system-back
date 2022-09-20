package edu.yangao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.SubwayCleanHistory;
import edu.yangao.entity.dto.SubwayCleanAndPartCleanHistorySaveDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryFindConditionDTO;
import edu.yangao.entity.dto.SubwayCleanHistoryUpdateStatusDTO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartAndSubwayInfoVO;
import edu.yangao.entity.vo.SubwayCleanHistoryWithPartGroupByCarriageVO;

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

    /**
     * 根据条件(分页)进行清理记录及其清洗的零件信息
     * @param conditionDTO 查询条件
     * @return 分页后的列表信息
     */
    IPage<SubwayCleanHistoryWithPartAndSubwayInfoVO> selectAllWithSubwayAndPartsByCondition(SubwayCleanHistoryFindConditionDTO conditionDTO);

    /**
     * 根据 地铁清理记录id 进行基础信息与其相关零件(根据车厢进行分组)的查找
     * @param subwayCleanHistoryId 地铁清理记录id
     * @return 包含地铁清理记录的基础信息(subwayCleanHistory) 和 零件信息
     */
    SubwayCleanHistoryWithPartGroupByCarriageVO selectAllWithPartsGroupByCarriageByCleanHistoryId(Integer subwayCleanHistoryId);

    /**
     * 更新地铁清理记录的状态(进度 状态随进度更新)
     * @param updateStatusDTO 要更新的信息(id, progress)
     * @return 更新情况
     */
    Boolean updateSubwayCleanHistoryStatus(SubwayCleanHistoryUpdateStatusDTO updateStatusDTO);

}
