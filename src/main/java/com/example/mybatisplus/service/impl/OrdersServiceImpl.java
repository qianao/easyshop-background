package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Orders;
import com.example.mybatisplus.mapper.OrdersMapper;
import com.example.mybatisplus.model.domain.UserAddr;
import com.example.mybatisplus.model.vo.OrderVO;
import com.example.mybatisplus.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单  服务实现类
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public IPage<OrderVO> selectPageWithStatusAddr(Integer pageNo, Integer pageSize, String status) {
        return ordersMapper.selectPageWithStatusAddr(new Page<OrderVO>(pageNo,pageSize),status);
    }

    @Override
    public boolean modifyStatus(Long id) {
        Orders orders=ordersMapper.selectById(id);
        UpdateWrapper<Orders> wrapper=new UpdateWrapper<Orders>();
        wrapper.eq("order_id",orders.getOrderId());
        orders.setStatus("2");
        if (orders.getPayTime()==null)
        orders.setPayTime(LocalDateTime.now());
        ordersMapper.update(orders,wrapper);
        return true;
    }
}
