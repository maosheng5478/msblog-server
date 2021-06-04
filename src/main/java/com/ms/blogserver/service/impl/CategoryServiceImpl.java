package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.blogserver.entity.Category;
import com.ms.blogserver.mapper.CategoryMapper;
import com.ms.blogserver.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/4
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}