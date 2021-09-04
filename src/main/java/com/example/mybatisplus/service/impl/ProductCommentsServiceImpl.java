package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.ProductComments;
import com.example.mybatisplus.mapper.ProductCommentsMapper;
import com.example.mybatisplus.model.vo.ProductCommentsVO;
import com.example.mybatisplus.service.ProductCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品评价  服务实现类
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Service
public class ProductCommentsServiceImpl extends ServiceImpl<ProductCommentsMapper, ProductComments> implements ProductCommentsService {

    @Autowired
    private ProductCommentsMapper productCommentsMapper;
    @Override
    public List<ProductCommentsVO> commentList(Long productId) {
        return productCommentsMapper.commentList(productId);
    }
}
