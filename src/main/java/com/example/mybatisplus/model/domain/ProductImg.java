package com.example.mybatisplus.model.domain;

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
 * 商品图片 
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProductImg对象", description="商品图片 ")
public class ProductImg extends Model<ProductImg> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "图片主键")
    private Long id;

            @ApiModelProperty(value = "商品外键id 商品外键id")
    private Long productId;

            @ApiModelProperty(value = "图片地址 图片地址")
    private String url;

            @ApiModelProperty(value = "顺序 图片顺序，从小到大")
    private Integer sort;

            @ApiModelProperty(value = "是否主图 是否主图，1：是，0：否")
    private Integer isMain;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModify;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
