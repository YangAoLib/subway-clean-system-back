package edu.yangao.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Setter;

/**
 * 统一结果返回信息
 *
 * @author YangAo
 */
@Data
@Schema(description = "统一结果返回信息")
public class Result<T> {

    @Schema(description = "状态码")
    private Integer status;

    @Schema(description = "消息")
    private String message;

    @Setter
    @Schema(description = "数据")
    private T data;

    /**
     * 成功操作, 不返回数据(data)
     *
     * @return 成功结果信息
     */
    public static Result<String> success() {
        return success("请求成功");
    }

    /**
     * 成功操作, 返回数据(data)
     *
     * @param data 数据
     * @param <D>  数据的类型
     * @return 成功结果信息
     */
    public static <D> Result<D> success(D data) {
        Result<D> result = new Result<>();
        // 设置基本错误信息
        result.setBaseErrorInfo(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 不推荐使用
     * 针对未存在的状态码, 允许自定义操作, 进行失败返回,
     *
     * @param status  状态码数字
     * @param message 状态码描述
     * @return 失败结果信息
     */
    public static Result<?> fail(Integer status, String message) {
        Result<?> result = new Result<>();
        // 设置基本错误信息
        result.setStatus(status);
        result.setMessage(message);
        return result;
    }

    /**
     * 针对基本错误信息, 进行失败返回
     *
     * @param baseErrorInfo 基本错误信息
     * @param clazz         额外携带信息的类型class
     * @param <D>           额外携带信息的类型
     * @return 失败结果信息
     */
    public static <D> Result<D> fail(BaseErrorInfoInterface baseErrorInfo, Class<D> clazz) {
        Result<D> result = new Result<>();
        // 设置基本错误信息
        result.setBaseErrorInfo(baseErrorInfo);
        return result;
    }

    /**
     * public static <D> Result<D> fail(BaseErrorInfoInterface baseErrorInfo, Class<D> clazz) 的 clazz = `Object.class` 版本
     *
     * @param baseErrorInfo 基本错误信息
     * @return 失败结果信息
     */
    public static Result<?> fail(BaseErrorInfoInterface baseErrorInfo) {
        return fail(baseErrorInfo, Object.class);
    }


    /**
     * 失败操作, 根据基本错误信息与额外数据进行返回
     *
     * @param baseErrorInfo 数据码
     * @param data          数据
     * @param <D>           数据类型
     * @return 失败结果信息
     */
    public static <D> Result<D> fail(BaseErrorInfoInterface baseErrorInfo, D data) {
        Result<D> result = new Result<>();
        // 设置基本错误信息
        result.setBaseErrorInfo(baseErrorInfo);
        // 设置数据
        result.setData(data);
        return result;
    }

    /**
     * 捕获异常自定义异常时, 进行失败返回, 数据为异常的message
     *
     * @param customServiceException 捕获的自定义异常
     * @return 失败结果信息
     */
    public static Result<String> fail(CustomServiceException customServiceException) {
        // 从自定义异常中获取 结果码和信息, 并设置
        return Result.fail(customServiceException.getBaseErrorInfo(), customServiceException.getLocalizedMessage());
    }


    /**
     * 设置基本错误信息
     *
     * @param baseErrorInfo 基本错误信息
     */
    private void setBaseErrorInfo(BaseErrorInfoInterface baseErrorInfo) {
        this.status = baseErrorInfo.getStatus();
        this.message = baseErrorInfo.getMessage();
    }
}
