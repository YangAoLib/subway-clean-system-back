package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.yangao.entity.PartCleanHistory;
import edu.yangao.entity.dto.PartMajorDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author YangAo
* @description 针对表【part_clean_history(零件清理历史记录)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.PartCleanHistory
*/
@Mapper
public interface PartCleanHistoryMapper extends BaseMapper<PartCleanHistory> {

    /**
     * 根据地铁清理记录id, 查询其包含清理的零件
     * @param subwayCleanHistoryId 地铁清理记录id
     * @return 零件信息列表
     */
    List<PartMajorDTO> selectPartsBySubwayCleanHistoryId(Integer subwayCleanHistoryId);

}




