package com.ms.blogserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ms.blogserver.entity.Category;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
public interface CategoryService extends IService<Category> {

    String getCategoryByCid(Integer categoryId);
}
