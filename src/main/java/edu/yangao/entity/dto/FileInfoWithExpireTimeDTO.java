package edu.yangao.entity.dto;

import edu.yangao.entity.FileInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author YangAo
 * @Description 文件信息 带有 过期时间
 * @create 2022-09-19 13:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "文件信息 带有 过期时间 传输类")
public class FileInfoWithExpireTimeDTO {

    public FileInfoWithExpireTimeDTO(FileInfo fileInfo, long timeout, TimeUnit timeUnit) {
        this.fileInfo = fileInfo;
        long time = new Date().getTime() + timeUnit.toMillis(timeout);
        this.expireDate = new Date(time);
    }

    /**
     * 过期时间
     */
    @Schema(description = "过期时间")
    private Date expireDate;

    /**
     * 文件信息
     */
    @Schema(description = "文件信息")
    private FileInfo fileInfo;
}
