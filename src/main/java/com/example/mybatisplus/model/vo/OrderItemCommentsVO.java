package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.OrderItem;
import com.example.mybatisplus.model.domain.ProductComments;
import lombok.Data;

@Data
public class OrderItemCommentsVO {
    private OrderItem orderItem;
    private ProductComments productComments;
}
