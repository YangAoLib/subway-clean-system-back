package edu.yangao.config;


import edu.yangao.util.CustomServiceException;
import edu.yangao.util.Result;
import edu.yangao.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangAo
 * @Description 全局异常处理类
 * @create 2022-06-01 20:34
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理全局自定义业务异常, 返回异常中的错误信息以及基本错误信息
     * @param exception 自定义业务异常
     * @return 错误请求, 统一返回信息
     */
    @ExceptionHandler({CustomServiceException.class})
    public Result<String> customServiceExceptionHandler(CustomServiceException exception) {
        logger.error("业务异常", exception);
        return Result.fail(exception);
    }

    /**
     * 全局处理参数校验异常, 返回异常中的错误信息以及基本错误信息
     * @param exception 参数校验异常
     * @return 错误请求, 统一返回信息
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<String> customServiceExceptionHandler(MethodArgumentNotValidException exception) {
        logger.error("参数传递错误", exception);
        return Result.fail(ResultCode.PARAM_IS_INVALID, exception.getLocalizedMessage());
    }

    /**
     * 全局处理空指针异常, 返回错误请求信息
     * @param exception 空指针异常
     * @return 错误请求统一返回信息
     */
    @ExceptionHandler({NullPointerException.class})
    public Result<String> customServiceExceptionHandler(NullPointerException exception) {
        logger.error("空指针异常", exception);
        return Result.fail(ResultCode.SYSTEM_ERROR, "空指针异常");
    }

    /**
     * 全局处理所有异常, 返回异常中的错误信息
     * @param exception 异常基类
     * @return 错误请求统一返回信息
     */
    @ExceptionHandler({Exception.class})
    public Result<String> customServiceExceptionHandler(Exception exception) {
        logger.error("系统异常", exception);
        return Result.fail(ResultCode.SYSTEM_ERROR, exception.getLocalizedMessage());
    }
}
