package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.OrderItemMapper;
import com.example.mybatisplus.mapper.OrdersMapper;
import com.example.mybatisplus.model.domain.OrderItem;
import com.example.mybatisplus.model.domain.UserAddr;
import com.example.mybatisplus.model.vo.OrderVO;
import com.example.mybatisplus.service.UserAddrService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.OrdersService;
import com.example.mybatisplus.model.domain.Orders;

import java.util.Iterator;
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
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final Logger logger = LoggerFactory.getLogger( OrdersController.class );

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserAddrService userAddrService;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Orders  orders =  ordersService.getById(id);
        return JsonResponse.success(orders).setCode(200);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        ordersService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResponse updateOrders(@PathVariable("id") Long  id,Orders  orders) throws Exception {
        orders.setOrderId(id);
        ordersService.updateById(orders);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Orders
    *
    */
    @RequestMapping(value = "/creat", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse create(@RequestBody Orders  orders) throws Exception {
        Long addrId=orders.getAddressId();
        UserAddr userAddr=userAddrService.getById(addrId);
        orders.setReceiverName(userAddr.getReceiverName());
        orders.setReceiverMobile(userAddr.getReceiverMobile());
        orders.setReceiverAddress(userAddr.getAddr());
        ordersService.save(orders);
        return JsonResponse.success(null).setData(orders.getOrderId());
    }




    /**
     * 描述：分页查询所有订单
     *
     */
    @RequestMapping("/listPage")
    public JsonResponse listPage(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize)throws Exception {
        return JsonResponse.success(ordersService.page(new Page<Orders>(pageNo,pageSize),null));
    }

    /**
     * 描述：分页查询某一分类的订单
     *
     */
    @RequestMapping("/listPageWithStatus")
    public JsonResponse listPageWithStatus(
                             @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false,defaultValue = "1") String status)throws Exception {
        return JsonResponse.success(ordersMapper.selectPageWithStatus(new Page<Orders>(pageNo,pageSize),status));
    }

    /**
     * 描述：分页查询某一分类的订单
     *
     */
    @RequestMapping("/listPageWithStatusById")
    public JsonResponse listPageWithStatusById(
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false,defaultValue = "1") String status,
            @Param("userId") Long userId)throws Exception {
        return JsonResponse.success(ordersMapper.selectPageWithStatusById(new Page<Orders>(pageNo,pageSize),status,userId));
    }

    /**
     * 描述：分页查询某一分类的订单
     *
     */
    @RequestMapping("/listPageWithStatus_addr")
    public JsonResponse listPageWithStatusAddr(
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false,defaultValue = "1") String status)throws Exception {
        return JsonResponse.success(ordersMapper.selectPageWithStatusAddr(new Page<OrderVO>(pageNo,pageSize),status));
    }

    /**
     * 描述：查询所有订单
     *
     */
    @RequestMapping("/list")
    public JsonResponse list()throws Exception {
        List<Orders> ordersList = ordersMapper.selectList(null);
        return JsonResponse.success(ordersList).setCode(200);
    }

    @RequestMapping("/paid/{id}")
    public JsonResponse modifyStatus(@PathVariable("id") Long  id)throws Exception{
        return JsonResponse.success(ordersService.modifyStatus(id));
    }

    /**
     * 描述：根据id把订单状态更新为5
     *
     */
    @RequestMapping("/updateStatusTo5ById")
    public JsonResponse updateStatusTo5ById(Long orderId)throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(orderId).setStatus("5");
        ordersService.updateById(orders);
        return JsonResponse.success(null).setCode(200).setMessage("更新订单状态成功");
    }

    /**
     * 描述：根据id把订单状态更新为3
     *  虽然挺蠢，但最后一会儿加的接口，不想改动原来的
     */
    @RequestMapping("/updateStatusTo3ById")
    public JsonResponse updateStatusTo3ById(Long orderId)throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(orderId).setStatus("3");
        ordersService.updateById(orders);
        return JsonResponse.success(null).setCode(200).setMessage("更新订单状态成功");
    }

    /**
     * 描述：根据id把订单状态更新为4
     *  虽然挺蠢，但最后一会儿加的接口，不想改动原来的
     */
    @RequestMapping("/updateStatusTo4ById")
    public JsonResponse updateStatusTo4ById(Long orderId)throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(orderId).setStatus("4");
        ordersService.updateById(orders);
        return JsonResponse.success(null).setCode(200).setMessage("更新订单状态成功");
    }

    /**
     * 描述：根据id把订单以及订单项都删除
     *
     */
    @RequestMapping("/deleteWithItemsById")
    @ResponseBody
    public JsonResponse deleteWithItemsById(Integer orderId)throws Exception {

        List<OrderItem> orderItemList = orderItemMapper.myListItemsByOrderId(orderId);

        Iterator<OrderItem> itemIterator = orderItemList.iterator();
        while(itemIterator.hasNext()){
            orderItemMapper.deleteById(itemIterator.next().getItemId());
        }

        ordersMapper.deleteById(orderId);
        return JsonResponse.success(null).setCode(200).setMessage("订单删除成功");
    }
}

