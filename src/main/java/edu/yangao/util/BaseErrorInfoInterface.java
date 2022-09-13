package edu.yangao.util;

/**
 * @author YangAo
 * @Description 基础错误信息类, 规范错误信息枚举类中的方法
 * @create 2022-06-01 20:42
 */
public interface BaseErrorInfoInterface {

    /**
     * 返回错误信息
     * @return 错误信息
     */
    String getMessage();

    /**
     * 返回错误代码
     * @return 错误代码
     */
    Integer getStatus();
}
