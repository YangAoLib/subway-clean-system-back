package edu.yangao.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YangAo
 * @Description 所有文件类型信息集合 传输类
 * @create 2022-08-23 18:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "所有文件类型信息集合 传输类")
public class FileInfoTotalDTO {

    /**
     * 点云文件存储信息
     */
    private List<FileInfoMajorDTO> pointCloudFileInfoList;

    /**
     * 图片文件存储信息
     */
    private List<FileInfoMajorDTO> pictureFileInfoList;

    /**
     * 其他文件存储信息
     */
    private List<FileInfoMajorDTO> otherFileInfoList;
}
