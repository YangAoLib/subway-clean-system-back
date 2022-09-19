package edu.yangao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author YangAo
 * @Description spring boot 启动类
 * @create 2022-08-22 15:06
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SubwayCleanSystemBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubwayCleanSystemBackApplication.class, args);
    }
}
