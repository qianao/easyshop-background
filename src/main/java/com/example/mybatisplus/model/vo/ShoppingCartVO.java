package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.model.domain.ProductImg;
import com.example.mybatisplus.model.domain.ProductParams;
import com.example.mybatisplus.model.domain.ShoppingCart;
import lombok.Data;

@Data
public class ShoppingCartVO {
    private ShoppingCart shoppingCart;
    private Product product;
    private ProductImg productImg;
    private ProductParams productParams;

}
