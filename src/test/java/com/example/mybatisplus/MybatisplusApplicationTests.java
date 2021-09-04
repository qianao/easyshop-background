package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.mapper.OrdersMapper;
import com.example.mybatisplus.mapper.ShoppingCartMapper;
import com.example.mybatisplus.mapper.UsersMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.OrderItem;
import com.example.mybatisplus.model.domain.ShoppingCart;
import com.example.mybatisplus.model.domain.Users;
import com.example.mybatisplus.model.vo.OrderVO;
import com.example.mybatisplus.model.vo.ShoppingCartVO;
import com.example.mybatisplus.service.AdminService;
import com.example.mybatisplus.service.OrderItemService;
import com.example.mybatisplus.service.OrdersService;
import com.example.mybatisplus.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.mail.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    OrderItemService orderItemService;
    @Test
    void contextLoads() throws EmailException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(100092L)
                .setProductId(8L)
                .setProductName("GUCCI风衣")
                .setProductImg("GUCCI风衣1.jpg");
        orderItemService.save(orderItem);
    }
}
