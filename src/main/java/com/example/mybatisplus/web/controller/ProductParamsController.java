package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.ProductImg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductParamsService;
import com.example.mybatisplus.model.domain.ProductParams;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2021-06-10
 * @version v1.0
 */
@Controller
@RequestMapping("/api/productParams")
public class ProductParamsController {

    private final Logger logger = LoggerFactory.getLogger( ProductParamsController.class );

    @Autowired
    private ProductParamsService productParamsService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        ProductParams  productParams =  productParamsService.getById(id);
        return JsonResponse.success(productParams);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productParamsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public JsonResponse updateProductParams(@PathVariable("id") Long  id,ProductParams  productParams) throws Exception {
//        productParams.setId(id);
//        productParamsService.updateById(productParams);
//        return JsonResponse.success(null);
//    }


    /**
    * 描述:创建ProductParams
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(ProductParams  productParams) throws Exception {
        productParamsService.save(productParams);
        return JsonResponse.success(null);
    }


    @RequestMapping(value = "/getParams", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(Long id, HttpServletResponse httpServletResponse)throws Exception {
        QueryWrapper<ProductParams> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",id);
        List<ProductParams> productParamsList = productParamsService.list(wrapper);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        System.out.println(productParamsList);
        return JsonResponse.success(productParamsList);
    }
}

