package edu.yangao.service.impl;

import edu.yangao.SubwayCleanSystemBackApplicationTest;
import edu.yangao.entity.dto.FileInfoWithExpireTimeDTO;
import edu.yangao.service.FileInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.Objects;

/**
 * @author YangAo
 * @Description
 * @create 2022-09-19 10:28
 */
class FileInfoServiceImplTest extends SubwayCleanSystemBackApplicationTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private FileInfoService service;

    @Test
    void testRedis() {
        FileInfoWithExpireTimeDTO fileInfo = (FileInfoWithExpireTimeDTO) redisTemplate.opsForValue().get("file:1cd4d51810d24012a46c67e9f3d2e680");
        System.out.println(Objects.nonNull(fileInfo) && fileInfo.getExpireDate().getTime() < new Date().getTime());
        redisTemplate.delete("file:1cd4d51810d24012a46c67e9f3d2e680");
        System.out.println(fileInfo);
    }
}
