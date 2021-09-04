package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author yym
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Users对象", description="")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "", type = IdType.AUTO)
            @ApiModelProperty(value = "主键id 用户id")
    private long userId;

            @ApiModelProperty(value = "用户名 用户名")
    private String username;

            @ApiModelProperty(value = "密码 密码")
    private String password;

            @ApiModelProperty(value = "头像 头像")
    private String userImg;

            @ApiModelProperty(value = "手机号 手机号")
    private String userMobile;

            @ApiModelProperty(value = "邮箱地址 邮箱地址")
    private String userEmail;

            @ApiModelProperty(value = "性别 M(男) or F(女)")
    private String userSex;

            @ApiModelProperty(value = "生日 生日")
    private LocalDate userBirth;

    @ApiModelProperty(value = "注册时间 创建时间")
    @TableField(fill = FieldFill.INSERT) // 插入的时候自动填充
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新时间 更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新的时候自动填充
    private LocalDateTime gmtModify;



            @ApiModelProperty(value = "逻辑删除")
    private Boolean isDelete;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
