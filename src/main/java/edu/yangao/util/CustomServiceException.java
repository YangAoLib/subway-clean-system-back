package edu.yangao.util;

/**
 * @author YangAo
 * @Description 自定义业务异常, 带有状态码信息
 * @create 2022-05-28 11:10
 */
public class CustomServiceException extends RuntimeException{


    public CustomServiceException(String message, BaseErrorInfoInterface baseErrorInfo) {
        super(message);
        this.baseErrorInfo = baseErrorInfo;
    }

    public BaseErrorInfoInterface getBaseErrorInfo() {
        return this.baseErrorInfo;
    }

    public void setBaseErrorInfo(BaseErrorInfoInterface baseErrorInfo) {
        this.baseErrorInfo = baseErrorInfo;
    }

    private BaseErrorInfoInterface baseErrorInfo;
    private static final long serialVersionUID = 7630603437187408838L;
}
