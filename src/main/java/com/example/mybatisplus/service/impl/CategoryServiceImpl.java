package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Category;
import com.example.mybatisplus.mapper.CategoryMapper;
import com.example.mybatisplus.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author zqa
 * @since 2021-06-18
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
