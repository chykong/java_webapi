package com.balance.util.string;

import javax.servlet.http.HttpServletRequest;
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
}
