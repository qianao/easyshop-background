package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.ProductVO;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
public interface ProductService extends IService<Product> {

    List<ProductVO> getProductList();

    List<ProductVO> getProductSearch(String product_name);
}
