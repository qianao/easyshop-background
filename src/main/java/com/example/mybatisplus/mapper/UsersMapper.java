package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yym
 * @since 2021-06-08
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {
    Users selectByNameAndPwd(@Param("name") String name);

    Users isExist(@Param("userId") String userId);

    void insertUser(@Param("userName") String userName, @Param("userId") String userId,@Param("userPwd") String userPwd,@Param("user_email") String user_email);
}
