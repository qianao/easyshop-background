package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.ProductComments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.vo.ProductCommentsVO;

import java.util.List;

/**
 * <p>
 * 商品评价  服务类
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
public interface ProductCommentsService extends IService<ProductComments> {

    List<ProductCommentsVO> commentList(Long productId);
}
