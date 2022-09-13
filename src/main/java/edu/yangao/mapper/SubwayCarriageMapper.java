package edu.yangao.mapper;

import edu.yangao.entity.SubwayCarriage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YangAo
* @description 针对表【subway_carriage(地铁车厢数据)】的数据库操作Mapper
* @createDate 2022-08-23 14:07:57
* @Entity edu.yangao.entity.SubwayCarriage
*/
@Mapper
public interface SubwayCarriageMapper extends BaseMapper<SubwayCarriage> {

}




