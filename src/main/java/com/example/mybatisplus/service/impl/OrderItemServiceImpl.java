package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.model.domain.OrderItem;
import com.example.mybatisplus.mapper.OrderItemMapper;
import com.example.mybatisplus.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单项/快照  服务实现类
 * </p>
 *
 * @author zqa
 * @since 2021-06-13
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public int countByProductIdAndDate(Long productId, String date) {
        UpdateWrapper<OrderItem> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("product_id",productId).like("gmt_create",date);
        return orderItemMapper.selectCount(updateWrapper);
    }

    @Override
    public List<String> getAllNames() {
        return orderItemMapper.myListItemsNames();
    }
}
