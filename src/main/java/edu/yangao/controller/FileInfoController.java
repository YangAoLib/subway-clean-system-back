package edu.yangao.controller;

import edu.yangao.service.FileInfoService;
import edu.yangao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author YangAo
 * @Description 文件及其信息操作类
 * @create 2022-09-17 19:40
 */
@RestController
@Tag(name = "文件及其信息操作类")
public class FileInfoController {

    /**
     * 文件上传
     * @param multipartFile 文件
     * @return 在 redis 中存储的id
     */
    @PostMapping("/file-info/upload")
    @Operation(summary = "文件上传")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        return Result.success(fileInfoService.uploadFile(multipartFile));
    }

    @Autowired
    private FileInfoService fileInfoService;
}
