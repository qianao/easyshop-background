package com.example.mybatisplus.model.domain;

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
 * 商品参数 
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProductParams对象", description="商品参数 ")
public class ProductParams extends Model<ProductParams> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "商品参数id")
            @TableId(value = "param_id")
    private Long paramId;

            @ApiModelProperty(value = "商品id")
    private Long productId;

            @ApiModelProperty(value = "规格重量 规格重量，例：35g")
    private String weight;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModify;

    private Float productPrice;

    private Integer productNum;

            @ApiModelProperty(value = "产品型号递增1-2-3")
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.paramId;
    }

}
