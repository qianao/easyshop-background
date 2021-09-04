package com.example.mybatisplus.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisplus.mapper.OrderItemMapper;
import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.service.ProductService;
import com.example.mybatisplus.model.vo.OrderItemCommentsVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.OrderItemService;
import com.example.mybatisplus.model.domain.OrderItem;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *
 *  前端控制器
 *
 *
 * @author zqa
 * @since 2021-06-13
 * @version v1.0
 */
@CrossOrigin
@Controller
@RequestMapping("/api/orderItem")
public class OrderItemController {

    private final Logger logger = LoggerFactory.getLogger( OrderItemController.class );

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemMapper orderItemMapper;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        OrderItem  orderItem =  orderItemService.getById(id);
        return JsonResponse.success(orderItem);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        orderItemService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateOrderItem(@PathVariable("id") Long  id,OrderItem  orderItem) throws Exception {
        orderItem.setItemId(id);
        orderItemService.updateById(orderItem);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建OrderItem
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody OrderItem  orderItem) throws Exception {
        Product product=productService.getById(orderItem.getProductId());
        orderItem.setProductName(product.getProductName());
        orderItemService.save(orderItem);
        return JsonResponse.success(null);
    }


    /**
     * 描述:根据orderID返回所有orderItem,用于罗列订单详情
     *
     */
    @RequestMapping("/listItemsByOrderId")
    @ResponseBody
    public JsonResponse listItemsByOrderId(Integer orderId) throws Exception {
        List<OrderItem> orderItemList = orderItemMapper.myListItemsByOrderId(orderId);
        return JsonResponse.success(orderItemList).setCode(200);
    }

    /**
     * 描述:连接查询
     * 根据orderID返回所有orderItem以及,用于罗列订单详情
     */
    @RequestMapping("/listItemsAndCommentsByOrderId")
    @ResponseBody
    public JsonResponse listItemsAndCommentsByOrderId(Integer orderId) throws Exception {
        List<OrderItemCommentsVO> orderItemCommentsVOs = orderItemMapper.myListItemsAndCommentsByOrderId(orderId);
        Iterator<OrderItemCommentsVO> iterator = orderItemCommentsVOs.iterator();
        int noCommentsNum =0;

        while(iterator.hasNext()){
            if (iterator.next().getOrderItem().getIsComment()==0)
                noCommentsNum++;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("noCommentsNum",noCommentsNum);

        return JsonResponse.success(orderItemCommentsVOs).setCode(200).setOtherData(jsonObject);
    }

    @RequestMapping("/adminCountSold/{pid}/{date}")
    @ResponseBody
    public JsonResponse countOrderItemByProduceIdAndData(@PathVariable("pid") Long produceId,
                                                                 @PathVariable("date") String date) throws Exception {
        int res=orderItemService.countByProductIdAndDate(produceId,date);
        return JsonResponse.success(null).setData(res);
    }
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllNames(){
        return orderItemService.getAllNames();
    }
}

