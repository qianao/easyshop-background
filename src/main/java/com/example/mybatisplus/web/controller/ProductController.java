package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.model.domain.Users;
import com.example.mybatisplus.model.vo.ProductVO;
import com.example.mybatisplus.model.vo.ShoppingCartVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductService;
import com.example.mybatisplus.model.domain.Product;

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
@RequestMapping("/api/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger( ProductController.class );

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/searchData")
    @ResponseBody
    public JsonResponse search(String secContent,HttpServletResponse response){
        System.out.println(secContent);
        response.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        List<ProductVO> productVOS = productService.getProductSearch(secContent);
        if (productVOS != null) {
            return JsonResponse.success(productVOS);
        }
        return JsonResponse.failure("未找到符合您需求的商品").setCode(201);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getProductList(HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        List<ProductVO> productVOS = productService.getProductList();

        if (productVOS != null) {
            return JsonResponse.success(productVOS);
        }
        return JsonResponse.failure("无数据").setCode(201);
    }


    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(Long id, HttpServletResponse httpServletResponse)throws Exception {
        Product  product =  productService.getById(id);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.success(product);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productService.removeById(id);
        return JsonResponse.success(null);
    }





    /**
    * 描述:创建Product
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Product  product) throws Exception {
        productService.save(product);
        return JsonResponse.success(null);
    }

    @RequestMapping("/listPage")
    @ResponseBody
    public JsonResponse listPage(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize)throws Exception {
        return JsonResponse.success(productService.page(new Page<Product>(pageNo,pageSize),null));
    }


    /**
     * 描述:根据categoryID返回所有product,用于此类商品
     *
     */
    @RequestMapping("/listProductByCateId")
    @ResponseBody
    public JsonResponse listProductByCateId(Integer categoryId) throws Exception {
        List<Product> productList = productMapper.myListProductByCateId(categoryId);
        return JsonResponse.success(productList).setCode(200);
    }
}

