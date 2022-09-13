package edu.yangao.mapper;

import edu.yangao.entity.PartCleanHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YangAo
* @description 针对表【part_clean_history(零件清理历史记录)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.PartCleanHistory
*/
@Mapper
public interface PartCleanHistoryMapper extends BaseMapper<PartCleanHistory> {

}




