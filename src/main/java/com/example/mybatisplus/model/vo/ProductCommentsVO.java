package com.example.mybatisplus.model.vo;

import com.example.mybatisplus.model.domain.ProductComments;
import com.example.mybatisplus.model.domain.Users;
import lombok.Data;

@Data
public class ProductCommentsVO {
    private ProductComments productComments;
    private Users users;
}
