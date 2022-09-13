package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.SubwayType;
import edu.yangao.service.SubwayTypeService;
import edu.yangao.mapper.SubwayTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author YangAo
* @description 针对表【subway_type(地铁类型)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:59
*/
@Service
public class SubwayTypeServiceImpl extends ServiceImpl<SubwayTypeMapper, SubwayType>
    implements SubwayTypeService{

}




