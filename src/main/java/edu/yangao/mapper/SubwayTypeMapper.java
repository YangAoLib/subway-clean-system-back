package edu.yangao.mapper;

import edu.yangao.entity.SubwayType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YangAo
* @description 针对表【subway_type(地铁类型)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:59
* @Entity edu.yangao.entity.SubwayType
*/
@Mapper
public interface SubwayTypeMapper extends BaseMapper<SubwayType> {

}




