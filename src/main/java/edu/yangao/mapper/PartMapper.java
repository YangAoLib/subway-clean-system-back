package edu.yangao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.yangao.entity.Part;
import edu.yangao.entity.dto.PartByCarriageDTO;
import edu.yangao.entity.dto.PartBySideDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author YangAo
* @description 针对表【part(零件信息)】的数据库操作Mapper
* @createDate 2022-08-22 17:49:58
* @Entity edu.yangao.entity.Part
*/
@Mapper
public interface PartMapper extends BaseMapper<Part> {

    /**
     * 根据车厢id获取其零件信息
     * @param subwayCarriageId 车厢id
     * @return 多个分组的 零件信息内部携带分组信息
     */
    List<PartBySideDTO> selectAllBySubwayCarriageId(@Param("subwayCarriageId") Integer subwayCarriageId);

    /**
     * 根据地铁清理记录id 获取零件信息
     * @param subwayCleanHistoryId 地铁清理记录id
     * @return 根据车厢分组的零件信息
     */
    List<PartByCarriageDTO> selectAllBySubwayCleanHistoryId(@Param("subwayCleanHistoryId") Integer subwayCleanHistoryId);
}




