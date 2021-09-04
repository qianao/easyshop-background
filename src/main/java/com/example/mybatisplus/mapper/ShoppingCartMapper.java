package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.vo.ShoppingCartVO;

import java.util.List;

/**
 * <p>
 * 购物车  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    List<ShoppingCartVO> cartList(Long user_id);


}
