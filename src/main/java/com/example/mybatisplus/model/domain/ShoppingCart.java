package com.example.mybatisplus.model.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ShoppingCart对象", description="购物车 ")
public class ShoppingCart extends Model<ShoppingCart> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "主键")
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Long cartId;

            @ApiModelProperty(value = "商品ID")
    private Long paramsId;

            @ApiModelProperty(value = "用户ID")
    private Long userId;

            @ApiModelProperty(value = "购物车商品数量")
    private String cartNum;

            @ApiModelProperty(value = "添加购物车时间")
    private String cartTime;

            @ApiModelProperty(value = "添加购物车时商品价格")
    private BigDecimal productPrice;

    private Long productId;


    @Override
    protected Serializable pkVal() {
        return this.cartId;
    }

}
