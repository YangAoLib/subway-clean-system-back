package edu.yangao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.yangao.entity.Part;
import edu.yangao.entity.dto.PartWithFileInfoDTO;
import edu.yangao.entity.vo.PartGroupWithFileVO;

import java.util.List;
import java.util.Map;

/**
* @author YangAo
* @description 针对表【part(零件信息)】的数据库操作Service
* @createDate 2022-08-22 17:49:58
*/
public interface PartService extends IService<Part> {

    /**
     * 根据地铁车厢id查询零件信息携带文件信息
     * @param subwayCarriageId 地铁车厢id
     * @return 分组的零件信息与文件信息
     */
    PartGroupWithFileVO getPartInfoWithFileGroup(Integer subwayCarriageId);

    /**
     * 根据地铁车厢名称查询零件信息携带文件信息
     * @param subwayCarriageName 地铁车厢名称
     * @return 分组的零件信息与文件信息
     */
    PartGroupWithFileVO getPartInfoWithFileGroup(String subwayCarriageName);

    /**
     * 根据地铁清理记录id 获取 根据车厢分组的零件信息
     * @param subwayCleanHistoryId 地铁清理记录id
     * @return 根据车厢分组的零件信息携带文件信息
     */
    Map<String, List<PartWithFileInfoDTO>> getPartInfoWithFileGroupByCarriage(Integer subwayCleanHistoryId);
}
