package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.ProductImg;
import com.example.mybatisplus.mapper.ProductImgMapper;
import com.example.mybatisplus.service.ProductImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-10
 */
@Service
public class ProductImgServiceImpl extends ServiceImpl<ProductImgMapper, ProductImg> implements ProductImgService {

}
