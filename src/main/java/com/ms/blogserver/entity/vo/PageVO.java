package com.ms.blogserver.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2021/5/27
 */
@Data
@ToString
public class PageVO<T> {
    //当前页，默认为1
    private Long current ;
    //每页数量，默认为5
    private Long size ;
    // 是否有下一页
    private int isMore;
    // 总记录数
    private Long total;
    // 总页数
    private Long totalPage;
    //分页结果
    private List<T> List;

    public PageVO(Long current, Long size, Long total) {
        super();
        this.current = current;
        this.size = size;
        this.total = total;
        this.totalPage = (this.total + this.size - 1) / this.size;
        this.isMore = this.current >= this.totalPage ? 0 : 1;
    }

    public PageVO() {
    }
}
