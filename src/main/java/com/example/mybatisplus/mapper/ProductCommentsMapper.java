package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.ProductComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.example.mybatisplus.model.vo.ProductCommentsVO;
import com.example.mybatisplus.model.vo.ShoppingCartVO;

import java.util.List;

/**
 * <p>
 * 商品评价  Mapper 接口
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Repository
public interface ProductCommentsMapper extends BaseMapper<ProductComments> {


    List<ProductCommentsVO> commentList(Long productId);

    List<ProductComments> myListProdCommentsByProdId(@Param("productId") Long productId);
}
