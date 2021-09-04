package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.OrderVO;

/**
 * <p>
 * 订单  服务类
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
public interface OrdersService extends IService<Orders> {
    IPage<OrderVO> selectPageWithStatusAddr(Integer pageNo, Integer pageSize, String status);

    boolean modifyStatus(Long id);
}
