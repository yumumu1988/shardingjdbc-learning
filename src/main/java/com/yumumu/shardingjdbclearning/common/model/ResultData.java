package com.yumumu.shardingjdbclearning.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghailin
 * @date 2022/6/1
 */
@Data
public class ResultData<T> implements Serializable {
    private static final long serialVersionUID = -402079470087250496L;

    private static final Integer SUCCESS = 1;
    private static final Integer FAILED = 0;

    private Integer status;
    private Integer errorCode;
    private String errorMsg;
    private T body;

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(SUCCESS);
        resultData.setBody(data);
        return resultData;
    }

    public static <T> ResultData<T> failed(Integer errorCode, String errorMsg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(FAILED);
        resultData.setErrorCode(errorCode);
        resultData.setErrorMsg(errorMsg);
        return resultData;
    }

    public static <T> ResultData<T> failed(String errorMsg) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(FAILED);
        resultData.setErrorMsg(errorMsg);
        return resultData;
    }
}
