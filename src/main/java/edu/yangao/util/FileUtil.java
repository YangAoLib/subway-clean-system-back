package edu.yangao.util;

import edu.yangao.entity.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author YangAo
 * @Description 文件工具类
 * @create 2022-09-17 19:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties("file-util")
public class FileUtil {

    /**
     * 存储路径
     */
    private String storagePath;

    private String redisDir;

    /**
     * 存储单个文件
     * @param multipartFile 文件内容
     * @return 文件的存储信息
     * @throws IOException 保存异常
     */
    public FileInfo uploadFile(MultipartFile multipartFile) throws IOException {
        // 生成存储信息
        String originName = multipartFile.getOriginalFilename();
        String generatedName = UUID.randomUUID().toString().replaceAll("-", "") + "-" + originName;
        String currentName = Path.of(generatedName).toString();
        Path path = Path.of(storagePath, currentName);
        File parentDir = path.getParent().toFile();
        // 前置路径不存在 并且 无法创建
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            throw new IOException("前置路径创建失败, 请自行创建或赋予权限");
        }
        // 进行存储操作
        multipartFile.transferTo(path);
        // 正常存储后返回信息
        return FileInfo.builder().originName(originName).currentName(currentName).fileAddress(path.toString()).build();
    }

    /**
     * 上传多个文件
     * @param multipartFiles 文件数据
     * @return 文件的存储信息
     * @throws IOException 保存异常
     */
    public List<FileInfo> uploadFile(MultipartFile[] multipartFiles) throws IOException {
        List<FileInfo> infos = new ArrayList<>(multipartFiles.length);
        for (MultipartFile file :
                multipartFiles) {
            infos.add(uploadFile(file));
        }
        return infos;
    }

    /**
     * 删除文件
     * @param path 相对路径
     * @return 是否删除成功
     * @exception IOException 文件不存在异常
     */
    public boolean deleteFile(String path) throws IOException {
        File file = Path.of(storagePath, path).toFile();
        if (!file.exists()) {
            throw new IOException("对应文件不存在, 请检查路径");
        }
        return file.delete();
    }

    /**
     * 删除文件
     * @param fileInfo 文件信息
     * @return 是否删除成功
     * @throws IOException 文件不存在异常
     */
    public boolean deleteFile(FileInfo fileInfo) throws IOException {
        return deleteFile(fileInfo.getCurrentName());
    }
}
