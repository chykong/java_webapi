package com.balance.util.json;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
public class JsonResult {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 消息
     */
    private String message;
    /**
     * 返回码
     */
    private String code;

    /**
     * 额外的数据
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(boolean success, String code, Object data) {
        this(success, code);
        this.data = data;
        this.message = ReturnCodeUtil.getMsg(code);
    }

    public JsonResult() {
    }

    public JsonResult(boolean success) {
        this.success = success;
    }

    /**
     * message通过code获取
     *
     * @param success
     * @param code
     */
    public JsonResult(boolean success, String code) {
        this(success);
        this.code = code;
        this.message = ReturnCodeUtil.getMsg(code);
    }

    /**
     * 三个参数，message自己赋值，不通过code获取
     *
     * @param success
     * @param code
     * @param message
     */
    public JsonResult(boolean success, String code, String message) {
        this(success);
        this.code = code;
        this.message = message;
    }

}
