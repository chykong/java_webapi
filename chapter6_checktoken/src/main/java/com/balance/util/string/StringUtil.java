package com.balance.util.string;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by 孔垂云 on 2017/12/24.
 */
public class StringUtil {
    /**
     * 根据从request中获取body的参数值
     *
     * @param br bufferreader
     * @return 字符串
     */
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }

    /**
     * 取得header的所有属性
     *
     * @param headers 请求的headers
     * @param request request
     * @return 把header拼成字符串
     */
    public static String getHeaderValue(Enumeration<String> headers, HttpServletRequest request) {
        String str = "";
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            str += header + "=" + request.getHeader(header) + "&";
        }
        return str;
    }

    /**
     * 判断字符串是null或空，null或""都返回true
     *
     * @param str 字符串
     * @return 是否
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 在controller或action里面打印字符串，返回给前台
     *
     * @param response response
     * @param str      字符串
     */
    public static void out(HttpServletResponse response, String str) {
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 判断字符串不是null或空
     *
     * @param str 字符串
     * @return 是否
     */
    public static boolean isNotNullOrEmpty(String str) {
        if (str != null && !str.equals("") && !str.equals("null")) {
            return true;
        } else {
            return false;
        }
    }


}
