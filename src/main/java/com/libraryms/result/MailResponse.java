package com.libraryms.result;


public class MailResponse<T> {
    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAILURE_MSG = "操作失败";
    public static final Integer SUCCESS_CODE = 0;
    public static final Integer FAILURE_CODE = -1;

    private Integer code;
    private String msg;
    private T data;

    public MailResponse() {
    }

    public MailResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public MailResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        data = null;
    }

    public static MailResponse buildFailureResp(Exception e) {
        return new MailResponse(MailResponse.FAILURE_CODE, e.getMessage());
    }

    public static MailResponse buildFailureResp(String msg) {
        return new MailResponse(MailResponse.FAILURE_CODE, msg);
    }

    public static MailResponse buildSuccessResp(Object data) {
        return new MailResponse(MailResponse.SUCCESS_CODE, MailResponse.SUCCESS_MSG, data);
    }

    public static MailResponse buildSuccessResp() {
        return new MailResponse(MailResponse.SUCCESS_CODE, MailResponse.SUCCESS_MSG);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


