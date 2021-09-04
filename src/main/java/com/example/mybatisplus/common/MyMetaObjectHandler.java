package com.example.mybatisplus.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @className: MyMetaObjectHandler
 * @Description: TODO
 * @version: v1.８.0
 * @author: GONGWENXUE
 * @date: 2021/6/8 11:04
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 实现插入时的自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert开始属性填充");
        this.strictInsertFill(metaObject,"gmtCreate", LocalDateTime.class,LocalDateTime.now());
        this.strictUpdateFill(metaObject,"gmtModified", LocalDateTime.class,LocalDateTime.now());
    }

    /**
     * 实现更新时的自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update开始属性填充");
        this.strictUpdateFill(metaObject,"gmtModified", LocalDateTime.class,LocalDateTime.now());
    }
}
