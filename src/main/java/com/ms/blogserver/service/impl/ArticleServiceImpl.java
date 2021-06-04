package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.converter.vo.ArticleVOConverter;
import com.ms.blogserver.dto.ArticleDTO;
import com.ms.blogserver.dto.GetCommentDTO;
import com.ms.blogserver.entity.Article;
import com.ms.blogserver.service.CategoryService;
import com.ms.blogserver.service.CommentService;
import com.ms.blogserver.utils.PageInfoUtil;
import com.ms.blogserver.vo.ArticleVO;
import com.ms.blogserver.mapper.ArticleMapper;
import com.ms.blogserver.service.ArticleService;
import com.ms.blogserver.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/1
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Override
    public ArticleVO getArticleById(Long id) {
        Article article = baseMapper.selectById(id);
        ArticleVO articleVO = ArticleVOConverter.INSTANCE.toData(article);
        articleVO.setTypeName(categoryService.getCategoryByCid(article.getType()));
        PageInfo<CommentVO> commentVOPageInfo = commentService.getPageByArticle(new GetCommentDTO(id));
        articleVO.setCommentVOS(commentVOPageInfo);
        return articleVO;
    }

    @Override
    public PageInfo<ArticleVO> getPage(ArticleDTO dto) {
        PageHelper.startPage(dto.getPage(),dto.getSize());
        List<Article> articleList = baseMapper.selectList(new LambdaQueryWrapper<Article>()
                .eq(Objects.nonNull(dto.getWriterId()),Article::getWriterId,dto.getWriterId())
                .eq(Objects.nonNull(dto.getType()),Article::getType,dto.getType())
                .eq(Objects.nonNull(dto.getTime()),Article::getCreateTime,dto.getTime()));
        // entity转vo
        List<ArticleVO> list = ArticleVOConverter.INSTANCE.toDataList(articleList);
        // 添加分类
        list.forEach(articleVO -> {
            articleVO.setTypeName(categoryService.getCategoryByCid(articleVO.getType()));
        });
        PageInfo<ArticleVO> res = new PageInfo<>();
        // PageInfo转换
        PageInfoUtil.transform(new PageInfo<>(articleList),res);
        res.setList(list);
        return res;
    }
}
