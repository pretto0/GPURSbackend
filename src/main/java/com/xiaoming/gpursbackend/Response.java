package com.xiaoming.gpursbackend;

public class Response <T>{

    private T data;
    private boolean success;
    private String errMessage;

    public static <K> Response<K> success(K data){
        Response<K> res = new Response<>();
        res.setData(data);
        res.setSuccess(true);
        return res;
    }

    public static <K> Response<K> fail(String errMessage){
        Response<K> res = new Response<>();
        res.setSuccess(false);
        res.setErrMessage(errMessage);
        return res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
