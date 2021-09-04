package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UserAddrService;
import com.example.mybatisplus.model.domain.UserAddr;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletResponse;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-08
 * @version v1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/api/userAddr")
public class UserAddrController {

    private final Logger logger = LoggerFactory.getLogger( UserAddrController.class );

    @Autowired
    private UserAddrService userAddrService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        UserAddr  userAddr =  userAddrService.getById(id);
        return JsonResponse.success(userAddr);
    }

    /**
    * 描述：根据Id删除
    *
    */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        userAddrService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateUserAddr(@PathVariable("id") Long  id, @RequestBody UserAddr  userAddr) throws Exception {
        userAddr.setAddrId(id);
        userAddrService.updateById(userAddr);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建UserAddr
    *
    */
    @RequestMapping(value = "/creat", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse create(UserAddr  userAddr,HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
//        userAddr.setAddrId(new UserAddr().getAddrId());
        userAddrService.save(userAddr);
        return JsonResponse.success(null);
    }


    /**
     * 描述:根据userID 找地址
     *
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAllAddr(Long userId, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return  JsonResponse.success(userAddrService.listAllByUserId(userId));
    }

    @RequestMapping(value = "/setDefault", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getDefautById(Long AddrId) throws  Exception{
        return JsonResponse.success(userAddrService.updataDefautByUserId(AddrId));
    }


    @RequestMapping("/listPage")
    @ResponseBody
    public JsonResponse listPage(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize)throws Exception {
        return JsonResponse.success(userAddrService.page(new Page<UserAddr>(pageNo,pageSize),null));
    }
}

