package com.balance.util.json;

import java.util.Map;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
public class ReturnCodeUtil {
    //定义返回码及文字数据
    private static Map<String, String> returnCodeMap;

    static {
        returnCodeMap.put(GlobalReturnCode.SAVE_SUCCESS, "保存成功");
        returnCodeMap.put(GlobalReturnCode.DELETE_SUCCESS, "删除成功");
        returnCodeMap.put(GlobalReturnCode.OPERA_SUCCESS, "操作成功");
        returnCodeMap.put(GlobalReturnCode.AUDIT_SUCCESS, "审核成功");

        
        returnCodeMap.put(GlobalReturnCode.OPERA_FAILURE, "操作失败");
        returnCodeMap.put("20102", "账号或密码错误");


        returnCodeMap.put(GlobalReturnCode.NO_AUTH, "无权限");
        returnCodeMap.put(GlobalReturnCode.SYSTEM_ERROR, "系统错误");
        returnCodeMap.put(GlobalReturnCode.PARAM_ERROR, "参数错误");
        returnCodeMap.put(GlobalReturnCode.SYSTEM_PATH_NOEXIST, "路径不存在");

    }


    /**
     * 获取返回的中文说明
     *
     * @param resultCode 返回码
     * @return 中文名称
     */
    public static String getMsg(String resultCode) {
        if (returnCodeMap.containsKey(resultCode)) {
            return returnCodeMap.get(resultCode);
        } else {
            return "";
        }
    }
}
