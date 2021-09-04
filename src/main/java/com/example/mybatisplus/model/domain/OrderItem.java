package com.example.mybatisplus.model.domain;

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
 * 订单项/快照 
 * </p>
 *
 * @author zqa
 * @since 2021-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderItem对象", description="订单项/快照 ")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "订单项ID")
            @TableId(value = "item_id",type = IdType.AUTO)
    private Long itemId;

            @ApiModelProperty(value = "订单ID")
    private Long orderId;

            @ApiModelProperty(value = "商品ID")
    private Long productId;

            @ApiModelProperty(value = "商品名称")
    private String productName;

            @ApiModelProperty(value = "商品图片")
    private String productImg;

            @ApiModelProperty(value = "skuID")
    private Long skuId;

            @ApiModelProperty(value = "sku名称")
    private String skuName;

            @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;

            @ApiModelProperty(value = "购买数量")
    private Integer buyCounts;

            @ApiModelProperty(value = "商品总金额")
    private BigDecimal totalAmount;

            @ApiModelProperty(value = "加入购物车时间")
    private LocalDateTime basketDate;

            @ApiModelProperty(value = "购买时间")
    private LocalDateTime buyTime;

            @ApiModelProperty(value = "评论状态： 0 未评价  1 已评价")
    private Integer isComment;

    @TableField(fill = FieldFill.INSERT) // 插入的时候自动填充
    private LocalDateTime gmtCreate;

            @ApiModelProperty(value = "修改时间")
            @TableField(fill = FieldFill.INSERT_UPDATE) // 插入的时候自动填充
    private LocalDateTime gmtModify;

    private Boolean isDelete;


    @Override
    protected Serializable pkVal() {
        return this.itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
