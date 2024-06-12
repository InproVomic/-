package org.example.library.model;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;//后端相应状态码
    private String errMsg;//发生错误原因
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data,String errMsg) {
        Result<T> result = new Result<T>();
        result.setCode(-1);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String errMsg) {
        Result<T> result = new Result<T>();
        result.setCode(-1);
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> Result<T> unLogin() {
        Result<T> result = new Result<T>();
        result.setCode(-2);
        result.setErrMsg("用户未登录");
        return result;
    }
}
