package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductImgService;
import com.example.mybatisplus.model.domain.ProductImg;

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
@RequestMapping("/api/productImg")
public class ProductImgController {

    private final Logger logger = LoggerFactory.getLogger( ProductImgController.class );

    @Autowired
    private ProductImgService productImgService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/getImg", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(Long id, HttpServletResponse httpServletResponse)throws Exception {
        QueryWrapper<ProductImg> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",id);
        List<ProductImg> productImgList = productImgService.list(wrapper);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        System.out.println(productImgList);
        return JsonResponse.success(productImgList);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productImgService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateProductImg(@PathVariable("id") Long  id,ProductImg  productImg) throws Exception {
        productImg.setId(id);
        productImgService.updateById(productImg);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建ProductImg
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(ProductImg  productImg) throws Exception {
        productImgService.save(productImg);
        return JsonResponse.success(null);
    }
}

