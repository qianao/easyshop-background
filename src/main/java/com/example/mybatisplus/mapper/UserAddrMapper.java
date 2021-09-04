package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.UserAddr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户地址  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-08
 */
public interface UserAddrMapper extends BaseMapper<UserAddr> {
    List<UserAddr> selectAllByUserId(@Param("userId") Long userId);
}
