package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.model.vo.ProductVO;
import com.example.mybatisplus.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductVO> getProductList() {
        return productMapper.getProductList();
    }

    @Override
    public List<ProductVO> getProductSearch(String product_name) {
        return productMapper.getProductSearch(product_name);
    }
}
