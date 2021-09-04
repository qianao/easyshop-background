package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单项/快照  服务类
 * </p>
 *
 * @author zqa
 * @since 2021-06-13
 */
public interface OrderItemService extends IService<OrderItem> {
    int countByProductIdAndDate(Long productId,String Date);

    List<String> getAllNames();
}
