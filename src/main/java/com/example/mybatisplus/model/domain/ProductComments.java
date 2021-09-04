package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 商品评价 
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProductComments对象", description="商品评价 ")
public class ProductComments extends Model<ProductComments> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value="ID")
            @TableId(value = "comm_id",type = IdType.AUTO)
    private Long commId;

            @ApiModelProperty(value = "商品id")
    private Long productId;

            @ApiModelProperty(value = "商品名称")
    private String productName;

            @ApiModelProperty(value = "订单项(商品快照)ID 可为空")
    private Long orderItemId;

            @ApiModelProperty(value = "评论用户id 用户名须脱敏")
    private Long userId;

            @ApiModelProperty(value = "是否匿名（1:是，0:否）")
    private Integer isAnonymous;

            @ApiModelProperty(value = "评价等级 1：好评 2：中评 3：差评")
    private Integer commLevel;

            @ApiModelProperty(value = "评价内容")
    private String commContent;

            @ApiModelProperty(value = "评价晒图(JSON {img1:url1,img2:url2}  )")
    private String commImgs;

            @ApiModelProperty(value = "评价时间 可为空")
    private LocalDateTime sepcName;

            @ApiModelProperty(value = "是否回复（0:未回复，1:已回复）")
    private Integer replyStatus;

            @ApiModelProperty(value = "回复内容")
    private String replyContent;

            @ApiModelProperty(value = "回复时间")
    private LocalDateTime replyTime;

            @ApiModelProperty(value = "是否显示（1:是，0:否）")
    private Integer isShow;

    private LocalDateTime gmtModify;

    private LocalDateTime gmtCreate;

    private Boolean isDelete;


    @Override
    protected Serializable pkVal() {
        return this.commId;
    }

}
