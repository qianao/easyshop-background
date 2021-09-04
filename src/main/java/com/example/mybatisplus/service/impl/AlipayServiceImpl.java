package com.example.mybatisplus.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.mybatisplus.aliPay.AliPayConfig;
import com.example.mybatisplus.service.AliPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @className: AlipayServiceImpl
 * @Description: TODO
 * @version: v1.８.0
 * @author: GONGWENXUE
 * @date: 2021/6/15 11:17
 */
@Service
@Slf4j
public class AlipayServiceImpl implements AliPayService {
    @Override
    public String aliPay(HttpServletResponse response, HttpServletRequest request, Long number,Double money) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AliPayConfig.return_url);
        aliPayRequest.setNotifyUrl(AliPayConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String order_number = new String(String.valueOf(number));
        //付款金额，从前台获取，必填
        String total_amount = money.toString();
        //订单名称，必填
        String subject = new String("臭猪张云婷");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        out.println(result);
        System.out.println("返回结果="+result);
        return result;
    }

    @Override
    public void returnUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String , String > params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //System.out.println("<--同步回调的值-->" + name + "\t\t" + valueStr);
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AliPayConfig.alipay_public_key, AliPayConfig.charset,AliPayConfig.sign_type);
        }catch (Exception e){
            System.out.println("报错：" + e.getMessage());
            e.printStackTrace();
        }

        if(signVerified) {
            try {
                System.out.println("<--同步回调签名验证-->" + signVerified);
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
                request.setAttribute("out_trade_no", out_trade_no);
                request.setAttribute("trade_no", "766");
                request.setAttribute("total_amount", total_amount);
            }catch (Exception e){
                System.out.println("报错：" + e.getMessage());
                e.printStackTrace();
            }


            //System.out.println("<--同步回调系统订单号-->" + out_trade_no + "\t\t<--同步回调支付宝交易号-->" + trade_no);
            //系统处理根据支付宝回调更改订单状态或者其他关联表的数据
        }else{
            request.setAttribute("reason", "验签失败");
        }
        request.setAttribute("signVerified", signVerified);
    }

    @Override
    public String notifyUrl(HttpServletRequest request) {
        return null;
    }

}
