package com.hnit.bmall.manage.utils;

/**
 * @author Ouyoung
 * @date 2020/4/29
 **/
public enum RespCode {

    SUCCESS(200, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
