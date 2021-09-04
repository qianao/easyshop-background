package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "商品主键id")
    @TableId(value = "product_id", type = IdType.AUTO)
    private Long productId;

            @ApiModelProperty(value = "商品名称 商品名称")
    private String productName;

            @ApiModelProperty(value = "分类外键id 分类id")
    private Long categoryId;

            @ApiModelProperty(value = "一级分类外键id 一级分类id，用于优化查询")
    private Long rootCategoryId;

            @ApiModelProperty(value = "销量 累计销售")
    private Integer soldNum;

            @ApiModelProperty(value = "默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架")
    private Integer productStatus;

            @ApiModelProperty(value = "商品内容 商品内容")
    private String content;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreat;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModify;


    @Override
    protected Serializable pkVal() {
        return this.productId;
    }

}
