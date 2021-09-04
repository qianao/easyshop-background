package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单  Mapper 接口
 * </p>
 *
 * @author zqa
 * @since 2021-06-08
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
    IPage<Orders> selectPageWithStatus(@Param("page") Page<Orders> page,@Param("status")String status);
    IPage<OrderVO> selectPageWithStatusAddr(@Param("page") Page<OrderVO> page, @Param("status")String status);

    IPage<Orders> selectPageWithStatusById(@Param("page") Page<Orders> page,
                                           @Param("status") String status,
                                           @Param("userId") Long userId);
}
