package edu.yangao.mapper;

import edu.yangao.entity.SubwayCleanHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YangAo
* @description 针对表【subway_clean_history(地铁清理历史记录)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.SubwayCleanHistory
*/
@Mapper
public interface SubwayCleanHistoryMapper extends BaseMapper<SubwayCleanHistory> {

}




