package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.mybatisplus.model.vo.ProductVO;


/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    List<ProductVO> getProductList();
    List<ProductVO> getProductSearch(String product_name);
    List<Product> myListProductByCateId(@Param("categoryId") Integer categoryId);
}
