package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Users;
import com.example.mybatisplus.mapper.UsersMapper;
import com.example.mybatisplus.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-07
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
