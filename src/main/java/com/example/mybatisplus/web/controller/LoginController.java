package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: LoginController
 * @Description: TODO
 * @version: v1.0
 * @author: yym
 * @date: 2021/6/8 16:27
 */

@Controller
public class LoginController {
//    @RequestMapping("/api/login")
//    @ResponseBody
//    public Map login(String username, String password, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
//        Map<String,Object> map = new HashMap<>();
//        String u = "admin";
//        String p = "admin";
//        if(u.equals(username)&&p.equals(password)){
//            map.put("status",200);
//        }else {
//            map.put("status",-1);
//        }
//        return map;
//    }
}
