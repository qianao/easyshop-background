package com.example.mybatisplus.model.domain;

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
 * 商品分类
 * </p>
 *
 * @author zqa
 * @since 2021-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Category对象", description="商品分类")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "主键 分类id主键")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

            @ApiModelProperty(value = "分类名称 分类名称")
    private String categoryName;

            @ApiModelProperty(value = "分类层级 分类得类型， 1:一级大分类 2:二级分类 3:三级小分类")
    private Integer categoryLevel;

            @ApiModelProperty(value = "父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级")
    private Long parentId;

            @ApiModelProperty(value = "分类图")
    private String categoryPic;

            @ApiModelProperty(value = "背景颜色")
    private String categoryBgColor;

    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.categoryId;
    }

}
