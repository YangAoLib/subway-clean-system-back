package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.yangao.entity.SubwayCarriage;
import edu.yangao.service.SubwayCarriageService;
import edu.yangao.mapper.SubwayCarriageMapper;
import org.springframework.stereotype.Service;

/**
* @author YangAo
* @description 针对表【subway_carriage(地铁车厢数据)】的数据库操作Service实现
* @createDate 2022-08-23 14:07:57
*/
@Service
public class SubwayCarriageServiceImpl extends ServiceImpl<SubwayCarriageMapper, SubwayCarriage>
    implements SubwayCarriageService{

}




