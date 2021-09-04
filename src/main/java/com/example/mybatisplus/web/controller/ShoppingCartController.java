package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.ShoppingCartMapper;
import com.example.mybatisplus.model.domain.ProductParams;
import com.example.mybatisplus.model.vo.ShoppingCartVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ShoppingCartService;
import com.example.mybatisplus.model.domain.ShoppingCart;
import com.example.mybatisplus.service.ProductParamsService;
import com.example.mybatisplus.model.domain.ProductParams;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@CrossOrigin
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {

    private final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductParamsService productParamsService;

    /**
     * 描述：根据Id 查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id) throws Exception {
        ShoppingCart shoppingCart = shoppingCartService.getById(id);
        return JsonResponse.success(shoppingCart);
    }

    /**
     * 描述：根据Id删除
     */
    @RequestMapping(value = "/delCart", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse deleteById(Long cartId, HttpServletResponse httpServletResponse) throws Exception {
        shoppingCartService.removeById(cartId);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.success(null);
    }


    /**
     * 描述：根据Id 更新
     */
    @RequestMapping(value = "/editCartNum", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse changeById(Long cartId, String cartNum, HttpServletResponse httpServletResponse) throws Exception {
        QueryWrapper<ShoppingCart> wrapper = new QueryWrapper<>();
        wrapper.eq("cart_id", cartId);
        ShoppingCart shoppingCart = shoppingCartService.getOne(wrapper);
        shoppingCart.setCartNum(cartNum);
        shoppingCartService.updateById(shoppingCart);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.success(null);
    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    @ResponseBody
//    public JsonResponse updateShoppingCart(@PathVariable("id") Long  id,ShoppingCart  shoppingCart) throws Exception {
//        shoppingCart.setId(id);
//        shoppingCartService.updateById(shoppingCart);
//        return JsonResponse.success(null);
//    }


    /**
     * 描述:创建ShoppingCart
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(ShoppingCart shoppingCart) throws Exception {
        shoppingCartService.save(shoppingCart);
        return JsonResponse.success(null);
    }

    @RequestMapping(value = "/getCartData", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(Long user_id, HttpServletResponse httpServletResponse) throws Exception {
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartService.cartlist(user_id);
        System.out.println(shoppingCartVOList);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        if (shoppingCartVOList != null) {
            return JsonResponse.success(shoppingCartVOList);
        }
        return JsonResponse.failure("无数据").setCode(201);
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse addCart(Long productId, String cartNum, Long userId, Long paramId, HttpServletResponse httpServletResponse) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

                QueryWrapper<ShoppingCart> wrapper0 = new QueryWrapper<>();
                wrapper0.eq("user_id", userId);
                wrapper0.eq("params_id", paramId);
                ShoppingCart shoppingCart = shoppingCartService.getOne(wrapper0);
                if(shoppingCart != null){
                    int oldnum  = Integer.parseInt(shoppingCart.getCartNum());
                    int addnum = Integer.parseInt(cartNum);
                    String num = String.valueOf(oldnum+addnum);
                    shoppingCart.setCartNum(num);
                    shoppingCartService.updateById(shoppingCart);
                    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
                    return JsonResponse.success(shoppingCart);
                }
        QueryWrapper<ProductParams> wrapper = new QueryWrapper<>();
        wrapper.eq("param_id", paramId);
        ProductParams productParams = productParamsService.getOne(wrapper);
        System.out.println(productParams);
        BigDecimal productPrice = new BigDecimal(Float.toString(productParams.getProductPrice()));
        ShoppingCart shoppingCart1 = new ShoppingCart().setProductId(productId).setCartNum(cartNum).setUserId(userId).setParamsId(paramId).setProductPrice(productPrice).setCartTime(df.format(new Date()));
        shoppingCartService.save(shoppingCart1);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        return JsonResponse.success(shoppingCart1);
    }

//    @RequestMapping(value = "/delCart", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResponse delCart(Long id){
//        shoppingCartService.removeById(id);
//        return JsonResponse.success(null);
//    }
}




