package edu.yangao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import edu.yangao.entity.Part;
import edu.yangao.entity.SubwayCarriage;
import edu.yangao.entity.dto.FileInfoMajorDTO;
import edu.yangao.entity.dto.PartByCarriageDTO;
import edu.yangao.entity.dto.PartWithFileInfoDTO;
import edu.yangao.entity.enums.ObjTypeEnum;
import edu.yangao.entity.vo.PartGroupWithFileVO;
import edu.yangao.mapper.PartMapper;
import edu.yangao.mapper.SubwayCarriageMapper;
import edu.yangao.service.FileInfoService;
import edu.yangao.service.PartService;
import edu.yangao.util.CustomServiceException;
import edu.yangao.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author YangAo
* @description 针对表【part(零件信息)】的数据库操作Service实现
* @createDate 2022-08-22 17:49:58
*/
@Service
public class PartServiceImpl extends ServiceImpl<PartMapper, Part>
    implements PartService{

    @Override
    public PartGroupWithFileVO getPartInfoWithFileGroup(Integer subwayCarriageId) {
        // 创建视图对象
        PartGroupWithFileVO vo = new PartGroupWithFileVO();
        // 填入车厢id
        vo.setSubwayCarriageId(subwayCarriageId);
        // 获取零件信息
        vo.setPartTotalMapFromSideParts(baseMapper.selectAllBySubwayCarriageId(subwayCarriageId));
        // 遍历获取文件信息 并 存储
        for (List<PartWithFileInfoDTO> list : vo.getPartTotalMap().values()) {
            for (PartWithFileInfoDTO item : list) {
                item.setFileTotalInfoMap(fileInfoService.getAllTypesOfFilesByObjIdAndObjType(item.getPart().getId(), ObjTypeEnum.PART, FileInfoMajorDTO.class));
            }
        }
        return vo;
    }

    @Override
    public PartGroupWithFileVO getPartInfoWithFileGroup(String subwayCarriageName) {
        // 根据名称查询车厢信息
        List<SubwayCarriage> list = ChainWrappers.lambdaQueryChain(subwayCarriageMapper).eq(SubwayCarriage::getName, subwayCarriageName).list();
        // 校验查询到的车厢信息是否正确
        if (list.size() == 0) {
            throw new CustomServiceException("未查询到对应车厢", ResultCode.PARAM_IS_INVALID);
        } else if (list.size() > 1) {
            throw new CustomServiceException("有多个对应车厢, 无法正确返回信息", ResultCode.PARAM_IS_INVALID);
        }
        return getPartInfoWithFileGroup(list.get(0).getId());
    }

    @Override
    public Map<String, List<PartWithFileInfoDTO>> getPartInfoWithFileGroupByCarriage(Integer subwayCleanHistoryId) {
        List<PartByCarriageDTO> partByCarriageDTOList = baseMapper.selectAllBySubwayCleanHistoryId(subwayCleanHistoryId);
        Map<String, List<PartWithFileInfoDTO>> map = new HashMap<>(partByCarriageDTOList.size());
        for (PartByCarriageDTO partByCarriageDTO : partByCarriageDTOList) {
            for (PartWithFileInfoDTO item : partByCarriageDTO.getPartsWithFile()) {
                item.setFileTotalInfoMap(fileInfoService.getAllTypesOfFilesByObjIdAndObjType(item.getPart().getId(), ObjTypeEnum.PART, FileInfoMajorDTO.class));
            }
            map.put(partByCarriageDTO.getSubwayCarriage().getName(), partByCarriageDTO.getPartsWithFile());
        }
        return map;
    }


    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private SubwayCarriageMapper subwayCarriageMapper;
}




