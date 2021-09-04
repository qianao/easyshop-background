package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.ProductParams;
import com.example.mybatisplus.mapper.ProductParamsMapper;
import com.example.mybatisplus.service.ProductParamsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品参数  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Service
public class ProductParamsServiceImpl extends ServiceImpl<ProductParamsMapper, ProductParams> implements ProductParamsService {

}
