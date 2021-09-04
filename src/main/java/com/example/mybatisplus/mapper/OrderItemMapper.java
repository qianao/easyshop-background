package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.vo.OrderItemCommentsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单项/快照  Mapper 接口
 * </p>
 *
 * @author zqa
 * @since 2021-06-13
 */
@Repository
public interface OrderItemMapper extends BaseMapper<OrderItem> {
    List<OrderItem> myListItemsByOrderId(@Param("orderId") Integer orderId);

    List<OrderItemCommentsVO> myListItemsAndCommentsByOrderId(@Param("orderId")Integer orderId);

    List<String> myListItemsNames();
}
