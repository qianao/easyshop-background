package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.model.domain.UserAddr;
import com.example.mybatisplus.mapper.UserAddrMapper;
import com.example.mybatisplus.service.UserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户地址  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-08
 */
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrMapper, UserAddr> implements UserAddrService {


    @Override
    public List<UserAddr> listAllByUserId(Long UserId) {
        return baseMapper.selectAllByUserId(UserId);
    }

    @Override
    public int updataDefautByUserId(Long AddrId) {
        UpdateWrapper<UserAddr> wrapper = new UpdateWrapper<UserAddr>()
                .set("common_addr", 1)
                .eq("addr_id",AddrId);
        baseMapper.update(null,wrapper);
        wrapper.clear();
        wrapper.set("common_addr",0)
                .notIn("addr_id",AddrId);
        baseMapper.update(null,wrapper);
        return 0;
    }
}
