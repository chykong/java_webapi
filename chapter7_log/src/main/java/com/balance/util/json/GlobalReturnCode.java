package com.balance.util.json;

/**
 * 全局返回码
 * Created by 孔垂云 on 2017/12/23.
 */
public class GlobalReturnCode {
    /**
     * 保存成功
     */
    public static final String SAVE_SUCCESS = "10001";
    /**
     * 删除成功
     */
    public static final String DELETE_SUCCESS = "10002";
    /**
     * 操作成功
     */
    public static final String OPERA_SUCCESS = "10003";
    /**
     * 审核成功
     */
    public static final String AUDIT_SUCCESS = "10004";

    /**
     * 操作失败
     */
    public static final String OPERA_FAILURE = "20001";

    /**
     * 无权限
     */
    public static final String NO_AUTH = "30001";
    /**
     * 系统错误
     */
    public static final String SYSTEM_ERROR = "30002";
    /**
     * 参数错误
     */
    public static final String PARAM_ERROR = "30003";

    /**
     * 路径不存在
     */
    public static final String SYSTEM_PATH_NOEXIST = "30004";
}
