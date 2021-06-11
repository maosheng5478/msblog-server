package com.ms.blogserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.ms.blogserver.constant.contexts.DigitalContexts;
import com.ms.blogserver.converter.bo.CommentBOConverter;
import com.ms.blogserver.converter.vo.CommentVOConverter;
import com.ms.blogserver.entity.Comment;
import com.ms.blogserver.bo.CommentBO;
import com.ms.blogserver.dto.GetCommentDTO;
import com.ms.blogserver.vo.CommentVO;
import com.ms.blogserver.mapper.CommentMapper;
import com.ms.blogserver.service.CommentService;
import com.ms.blogserver.service.UserService;
import com.ms.blogserver.utils.PageInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/6/2
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public List<Comment> getAllCommentByArticleId(Long articleId) {
        return baseMapper.selectList(new QueryWrapper<Comment>().eq("article_id", articleId));
    }

    @Override
    public List<CommentVO> getParentId(Long pid) {
        List<Comment> list = baseMapper.selectList(new QueryWrapper<Comment>().eq("parent_id", pid));
        List<CommentBO> commentBOList = CommentBOConverter.INSTANCE.toDataList(list);
        return setString(commentBOList);
    }

    @Override
    public PageInfo<CommentVO> getPageByArticle(GetCommentDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<Comment> allComment = getAllCommentByArticleId(dto.getArticleId());
        List<CommentBO> commentBOList = CommentBOConverter.INSTANCE.toDataList(allComment);
        List<CommentVO> commentVOList = setString(commentBOList);
        handle(commentVOList);
        PageInfo<CommentVO> commentVOPageInfo = new PageInfo<>();
        PageInfoUtil.transform(new PageInfo<>(allComment),commentVOPageInfo);
        commentVOPageInfo.setList(commentVOList);
        return commentVOPageInfo;
    }

    private  List<CommentVO> setString(List<CommentBO> commentBOList) {
        commentBOList.forEach(commentBO -> {
            commentBO.setCommenter(userService.getUserByID(commentBO.getCommenterId()).getUsername());
            Long resID = commentBO.getRespondentId();
            if (!resID.equals(DigitalContexts.ZERO_LONG)){
                commentBO.setRespondent(userService.getUserByID(resID).getUsername());
            }
        });
        return CommentVOConverter.INSTANCE.toDataList(commentBOList);
    }

    private void handle(List<CommentVO> list){
        list.forEach(commentVO -> {
            List<CommentVO> children =getParentId(commentVO.getId());
            commentVO.setChildren(children);
        });
        list.removeIf(commentVO -> !commentVO.getParentId().equals(DigitalContexts.ZERO_LONG));
    }
}
