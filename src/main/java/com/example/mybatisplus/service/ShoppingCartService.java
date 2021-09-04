package com.example.mybatisplus.service;

import com.example.mybatisplus.mapper.ShoppingCartMapper;
import com.example.mybatisplus.model.domain.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 购物车  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
public interface ShoppingCartService extends IService<ShoppingCart> {


    List<ShoppingCartVO> cartlist(Long user_id);
}
