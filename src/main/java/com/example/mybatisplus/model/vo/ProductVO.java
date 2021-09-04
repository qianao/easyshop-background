package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.model.domain.ProductImg;
import com.example.mybatisplus.model.domain.ProductParams;
import lombok.Data;

@Data
public class ProductVO {
    private Product product;
    private ProductImg productImg;
    private ProductParams productParams;
}
