package com.balance.config.filter;

/**
 * Created by 孔垂云 on 2017/9/10.
 */

import jodd.io.StreamUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HttpBody的过滤器
 *
 * @author 孔垂云
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 定义字节流
     */
    private final byte[] body;

    /**
     * 把请求的http包装一下
     *
     * @param request request
     * @throws IOException IO异常
     */
    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request)
            throws IOException {
        super(request);
        // body = StreamUtil.readBytes(request.getReader(), JoddDefault.encoding);
        // 因为http协议默认传输的编码就是iso-8859-1,如果使用utf-8转码乱码的话，可以尝试使用iso-8859-1
        body = StreamUtil.readBytes(request.getReader(), "UTF-8");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }
}

