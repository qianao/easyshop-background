package com.example.mybatisplus.model.domain;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单 
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="订单 ")
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "订单ID 同时也是订单编号")
            @TableId(value = "order_id",type = IdType.AUTO)
    private Long orderId;

            @ApiModelProperty(value = "用户ID")
    private Long userId;

            @ApiModelProperty(value= "与订单关联的地址id")
    private Long addressId;

            @ApiModelProperty(value = "收货人快照")
    private String receiverName;

            @ApiModelProperty(value = "收货人手机号快照")
    private String receiverMobile;

            @ApiModelProperty(value = "收货地址快照")
    private String receiverAddress;

            @ApiModelProperty(value = "订单总价格")
    private BigDecimal totalAmount;

            @ApiModelProperty(value = "实际支付总价格")
    private Integer actualAmount;

            @ApiModelProperty(value = "支付方式 1:微信 2:支付宝")
    private Integer payType;

            @ApiModelProperty(value = "订单备注")
    private String orderRemark;

            @ApiModelProperty(value = "订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:已完成 6:已关闭")
    private String status;

            @ApiModelProperty(value = "配送方式")
    private String deliveryType;

            @ApiModelProperty(value = "物流单号")
    private Long deliveryFlowId;

            @ApiModelProperty(value = "订单运费 默认可以为零，代表包邮")
    private BigDecimal orderFreight;

            @ApiModelProperty(value = "付款时间")
    private LocalDateTime payTime;

            @ApiModelProperty(value = "发货时间")
    private LocalDateTime deliveryTime;

            @ApiModelProperty(value = "完成时间")
    private LocalDateTime flishTime;

            @ApiModelProperty(value = "取消时间")
    private LocalDateTime cancelTime;

            @ApiModelProperty(value = "订单关闭类型1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易")
    private Integer closeType;

            @ApiModelProperty(value = "更新时间")
            @TableField(fill = FieldFill.INSERT_UPDATE) // 插入的时候自动填充
    private LocalDateTime gmtModify;

            @ApiModelProperty(value = "创建时间（成交时间）")
            @TableField(fill = FieldFill.INSERT) // 插入的时候自动填充
    private LocalDateTime gmtCreate;

            @ApiModelProperty(value = "逻辑删除状态 1: 删除 0:未删除")
    private Boolean isDelete;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
