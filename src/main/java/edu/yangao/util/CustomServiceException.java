package edu.yangao.util;


import java.util.Arrays;
import java.util.List;

/**
 * @author YangAo
 * @Description 自定义业务异常, 带有状态码信息
 * @create 2022-05-28 11:10
 */
public class CustomServiceException extends RuntimeException{

    public CustomServiceException(String message, BaseErrorInfoInterface baseErrorInfo, Exception... exceptions) {
        super(message);
        this.baseErrorInfo = baseErrorInfo;
        this.exceptions = Arrays.asList(exceptions);
    }

    public CustomServiceException(String message, BaseErrorInfoInterface baseErrorInfo, List<Exception> exceptions) {
        super(message);
        this.baseErrorInfo = baseErrorInfo;
        this.exceptions = exceptions;
    }
    public BaseErrorInfoInterface getBaseErrorInfo() {
        return this.baseErrorInfo;
    }

    public void setBaseErrorInfo(BaseErrorInfoInterface baseErrorInfo) {
        this.baseErrorInfo = baseErrorInfo;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    private BaseErrorInfoInterface baseErrorInfo;
    private List<Exception> exceptions;
    private static final long serialVersionUID = 7630603437187408838L;
}
