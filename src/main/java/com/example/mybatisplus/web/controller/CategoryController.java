package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.CategoryService;
import com.example.mybatisplus.model.domain.Category;


/**
 *
 *  前端控制器
 *
 *
 * @author zqa
 * @since 2021-06-18
 * @version v1.0
 */
@Controller
@RequestMapping("/api/category")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger( CategoryController.class );

    @Autowired
    private CategoryService categoryService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Category  category =  categoryService.getById(id);
        return JsonResponse.success(category);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        categoryService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateCategory(@PathVariable("id") Long  id,Category  category) throws Exception {
        category.setCategoryId(id);
        categoryService.updateById(category);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Category
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Category  category) throws Exception {
        categoryService.save(category);
        return JsonResponse.success(null);
    }

    @RequestMapping("/listPage")
    @ResponseBody
    public JsonResponse listPage(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize)throws Exception {
        return JsonResponse.success(categoryService.page(new Page<Category>(pageNo,pageSize),null));
    }
}

