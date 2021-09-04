package com.example.mybatisplus.web.controller;

/**
 * @className: GoAliPay
 * @Description: TODO
 * @version: v1.８.0
 * @author: GONGWENXUE
 * @date: 2021/6/15 10:38
 */

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.mybatisplus.aliPay.AliPayConfig;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("api/payment")
public class GoAliPayController{
    @Autowired
    AliPayService aliPayService;

    @RequestMapping(value = "/pay/{number}/{money}")
//    @ResponseBody
    public void payMent(@PathVariable("number") Long number,@PathVariable("money") Double money, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //创建PC场景下单并支付请求对象
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(AliPayConfig.return_url);
        String result=new String();
        try {
            result=aliPayService.aliPay(response, request,number,money);
//            aliPayService.returnUrl(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return JsonResponse.success(1).setMessage(result);
    }

//    @PostMapping(value = "/notify_url")
//    public String notifyUrl(HttpServletRequest request){
//        String orderNumber = aliPayService.notifyUrl(request);
//        System.out.println("【异步通知返回的订单号】" + orderNumber);
//        if (!orderNumber.equals("fail")){
//            Tcharge chargeInfo = chargeService.selectDataByOrderNumber(orderNumber);
//            if (chargeInfo != null){
//                chargeInfo.setPayStatus("已支付");
//                chargeService.updateChargeData(chargeInfo);
//                System.out.println("【异步通知订单更新完成！】");
//            }else {
//                System.out.println("【异步通知订单更新失败！】");
//            }
//        }
//        return "recordTab";
//    }


    /**【同步跳转，告诉你是否调用成功，不能拿来判断支付成功】**/
    @GetMapping(value = "/return_url")
    public String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        aliPayService.returnUrl(request);
        return "Index";
    }

}
