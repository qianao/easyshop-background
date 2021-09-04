package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 用户地址 
 * </p>
 *
 * @author lxp
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserAddr对象", description="用户地址 ")
public class UserAddr extends Model<UserAddr> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "地址主键id")
    @TableId(value = "addr_id", type = IdType.AUTO)
    private Long addrId;

            @ApiModelProperty(value = "用户ID")
    private Long userId;

            @ApiModelProperty(value = "收件人姓名")
    private String receiverName;

            @ApiModelProperty(value = "收件人手机号")
    private String receiverMobile;

            @ApiModelProperty(value = "省份")
    private String province;

            @ApiModelProperty(value = "城市")
    private String city;

            @ApiModelProperty(value = "区县")
    private String area;

            @ApiModelProperty(value = "详细地址")
    private String addr;

            @ApiModelProperty(value = "邮编")
    private String postCode;

            @ApiModelProperty(value = "状态,1正常，0无效")
    private Integer status;

            @ApiModelProperty(value = "是否默认地址 1是 1:是  0:否")
    private Integer commonAddr;


            @ApiModelProperty(value = "创建时间")
            @TableField(fill = FieldFill.INSERT) // 插入的时候自动填充
    private LocalDateTime gmtCreate;


            @ApiModelProperty(value = "更新时间")
            @TableField(fill = FieldFill.INSERT_UPDATE) // 插入的时候自动填充
    private LocalDateTime gmtModify;


    @Override
    protected Serializable pkVal() {
        return this.addrId;
    }

}
