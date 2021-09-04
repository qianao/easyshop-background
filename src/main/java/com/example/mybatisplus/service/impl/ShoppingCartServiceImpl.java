package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.ShoppingCart;
import com.example.mybatisplus.mapper.ShoppingCartMapper;
import com.example.mybatisplus.model.vo.ShoppingCartVO;
import com.example.mybatisplus.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public List<ShoppingCartVO> cartlist(Long user_id) {

        return shoppingCartMapper.cartList(user_id);
    }
}
