package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.UsersMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UsersService;
import com.example.mybatisplus.model.domain.Users;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.*;

import java.util.Random;


/**
 *
 *  前端控制器
 *
 *
 * @author yym
 * @since 2021-06-07
 * @version v1.0
 */
@CrossOrigin
@Controller
public class UsersController {

    private final Logger logger = LoggerFactory.getLogger( UsersController.class );

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public JsonResponse hello(){
        return JsonResponse.success(null).setCode(200).setMessage("SpingBoot部署成功");
    }

    @RequestMapping("/api/login")
    @ResponseBody
    public JsonResponse login(String username,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        Users users= usersMapper.selectByNameAndPwd(username);
        if(users != null){
            return JsonResponse.success(users);
        }
        return JsonResponse.failure("用户名不存在").setCode(201);
    }

    @RequestMapping("/api/users/logout")
    @ResponseBody
    public JsonResponse logout(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.successMessage("注销成功");
    }

    @RequestMapping("/api/users/userExist")
    @ResponseBody
    public JsonResponse userExist(String userId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        Users users=usersMapper.isExist(userId);
        if(users != null){
            return JsonResponse.success(null).setCode(1);//用户已存在
        }
        else{
            return JsonResponse.success(null).setCode(2);//用户不存在
        }
    }

    @RequestMapping("/api/users/register")
    @ResponseBody
    public JsonResponse register(String userName,String userId,String userPwd,String user_email,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加

        usersMapper.insertUser(userName,userId,userPwd,user_email);
        return JsonResponse.successMessage("插入用户成功");
    }

    @RequestMapping("/api/users/send_code")
    @ResponseBody
    public JsonResponse send_code(String user_email,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        String val = "";
        Random random = new Random();
        for(int i=0;i<6;i++){
            val += String.valueOf(random.nextInt(10));
        }
        try {
            HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(user_email);// 收件地址
            email.setFrom("yangyming123@163.com", "Group05商城");//此处填邮箱地址和用户名,用户名可以任意填写
            email.setAuthentication("yangyming123@163.com", "JIXKFCKUIWDFUBIC");//此处填写邮箱地址和客户端授权码
            email.setSubject("注册验证码");//此处填写邮件名，邮件名可任意填写
            email.setMsg("尊敬的用户您好,您本次注册的验证码是:\n" + val);//此处填写邮件内容
            // email.setSSLOnConnect(false);
            //启用ssl加密
            email.setSSLOnConnect(true);
            //使用465端口(不设置也可，ssl默认为465)
            email.setSslSmtpPort("465");
            email.send();
            return JsonResponse.successMessage(val);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return JsonResponse.failure("邮件发送失败！");
    }

    @RequestMapping("api/users/Login")
    @ResponseBody
    public JsonResponse checkLogin(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.successMessage("校对成功");
    }

    @RequestMapping("api/users/checkLogin")
    public JsonResponse checkLogin1(HttpServletResponse response){
        checkLogin(response);
        return JsonResponse.successMessage("校对成功");
    }

    /**
     * 描述:创建Users
     *
     */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResponse create(Users  users) throws Exception {
//        usersService.save(users);
//        return JsonResponse.success(null);
//    }

    @RequestMapping("/api/users/listPage")
    @ResponseBody
    public JsonResponse listPage(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize)throws Exception {
        return JsonResponse.success(usersService.page(new Page<Users>(pageNo,pageSize),null));
    }

}
