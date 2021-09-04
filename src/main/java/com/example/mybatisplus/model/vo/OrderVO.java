package com.example.mybatisplus.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @className: OrderVO
 * @Description: TODO
 * @version: v1.８.0
 * @author: GONGWENXUE
 * @date: 2021/6/16 11:05
 */
public class OrderVO {

    private Long orderId;
    private Long userId;
    private String receiverName;
    private String receiverMobile;
    private String address;
    private Integer actualAmount;
    private String deliveryType;

}
