package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.UserAddr;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户地址  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-08
 */
public interface UserAddrService extends IService<UserAddr> {
    List<UserAddr> listAllByUserId(Long UserId);
    int updataDefautByUserId(Long UserId);
}
