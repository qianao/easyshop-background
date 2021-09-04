package com.example.mybatisplus.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface AliPayService {

    /**
     * 支付宝支付调用接口
     * @param response
     * @param request
     * @throws IOException
     */
    String aliPay(HttpServletResponse response, HttpServletRequest request, Long number,Double money) throws IOException;

    void returnUrl(HttpServletRequest request) throws UnsupportedEncodingException;

    String notifyUrl(HttpServletRequest request);
}
