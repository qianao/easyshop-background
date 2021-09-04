package com.example.mybatisplus.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.OrderItemMapper;
import com.example.mybatisplus.mapper.ProductCommentsMapper;
import com.example.mybatisplus.model.domain.OrderItem;
import com.example.mybatisplus.service.OrderItemService;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.ProductParams;
import com.example.mybatisplus.model.vo.ProductCommentsVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductCommentsService;
import com.example.mybatisplus.model.domain.ProductComments;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author zqa
 * @since 2021-06-08
 * @version v1.0
 */
@CrossOrigin
@Controller
@RequestMapping("/api/productComments")
public class ProductCommentsController {

    private final Logger logger = LoggerFactory.getLogger( ProductCommentsController.class );

    @Autowired
    private ProductCommentsService productCommentsService;
    @Autowired
    private ProductCommentsMapper productMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private ProductCommentsMapper productCommentsMapper;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        ProductComments  productComments =  productCommentsService.getById(id);
        return JsonResponse.success(productComments);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productCommentsService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateProductComments(@PathVariable("id") Long  id,ProductComments  productComments) throws Exception {
        productComments.setCommId(id);
        productCommentsService.updateById(productComments);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建ProductComments
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(ProductComments  productComments) throws Exception {
        productCommentsService.save(productComments);
        return JsonResponse.success(null);
    }

    /**
     * 描述:根据item_id的一个列表查询product_comments
     *
     */
    @RequestMapping(value = "/getByitemIdList",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getByitemIdList(JSONObject jsonObject) throws Exception {
        List<Long> longList = JSONObject.parseArray(jsonObject.toJSONString(),Long.class);
        QueryWrapper<ProductComments> wrapper = new QueryWrapper<>();
//        wrapper.eq("order_item_id",commentIdList);

        return JsonResponse.success(productMapper.selectOne(wrapper));
    }

    /**
     * 描述:接收item_id，查询对应的orderItem信息，拼接成一个productComment然后插入
     * 成功后需要把对应orderitem的status更新为1
     */
    @RequestMapping(value = "/insertComment",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse insertComment(Long itemId,Long userId,
                                      Boolean isanonymous,String commContent,
                                      Integer commLevel) throws Exception {
        Integer isAnonymous;
        if(isanonymous) isAnonymous =1;
        else isAnonymous =0;

        QueryWrapper<OrderItem> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("item_id",itemId);

        OrderItem orderItem = orderItemMapper.selectOne(wrapper1);

        OrderItem orderItemForUpdate =new OrderItem();
        orderItemForUpdate.setIsComment(1).setItemId(orderItem.getItemId());
        orderItemMapper.updateById(orderItemForUpdate);

        ProductComments productComments = new ProductComments();

        productComments
                .setCommContent(commContent)
                .setCommImgs(orderItem.getProductImg())
                .setCommLevel(commLevel)
                .setIsAnonymous(isAnonymous)
                .setUserId(userId)
                .setOrderItemId(itemId)
                .setProductId(orderItem.getProductId())
                .setProductName(orderItem.getProductName())
                .setSepcName(LocalDateTime.now());

        productCommentsService.save(productComments);
        return JsonResponse.success(null);
    }

    /**
     * 描述:接收item_id，查询对应的orderItem信息，拼接成一个productComment然后插入
     * 成功后需要把对应orderitem的status更新为1
     */
    @RequestMapping(value = "/insertComment1",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse insertComment1(JSONObject orderItemParams) throws Exception {

        System.out.println(orderItemParams);
        System.out.println("我是傻逼");
        System.out.println(orderItemParams.get("itemId"));
//        Integer isAnonymous;
//        if(isanonymous) isAnonymous =1;
//        else isAnonymous =0;
//
//        QueryWrapper<OrderItem> wrapper1 = new QueryWrapper<>();
//        wrapper1.eq("item_id",itemId);
//
//        OrderItem orderItem = orderItemMapper.selectOne(wrapper1);
//
//        OrderItem orderItemForUpdate =new OrderItem();
//        orderItemForUpdate.setIsComment(1).setItemId(orderItem.getItemId());
//        orderItemMapper.updateById(orderItemForUpdate);
//
//        ProductComments productComments = new ProductComments();
//
//        productComments
//                .setCommContent(commContent)
//                .setCommImgs(orderItem.getProductImg())
//                .setCommLevel(commLevel)
//                .setIsAnonymous(isAnonymous)
//                .setUserId(userId)
//                .setOrderItemId(itemId)
//                .setProductId(orderItem.getProductId())
//                .setProductName(orderItem.getProductName())
//                .setSepcName(LocalDateTime.now());
//
//        productCommentsService.save(productComments);
        return JsonResponse.success(null);
    }



    @RequestMapping(value = "/getComment", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(Long productId, HttpServletResponse httpServletResponse)throws Exception {

        List<ProductCommentsVO> productCommentsVOList = productCommentsService.commentList(productId);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");// 部分浏览器需加
        System.out.println(productCommentsVOList);
        return JsonResponse.success(productCommentsVOList);
    }

    /**
     * 描述:根据productID返回所有productComments
     *  zqa
     */
    @RequestMapping("/listProdCommentsByProdId")
    @ResponseBody
    public JsonResponse listProdCommentsByProdId(Long productId) throws Exception {
        List<ProductComments> productCommentsList = productCommentsMapper.myListProdCommentsByProdId(productId);
        return JsonResponse.success(productCommentsList).setCode(200);
    }
}

