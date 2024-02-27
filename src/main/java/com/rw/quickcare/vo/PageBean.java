package com.rw.quickcare.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName PageBean
 * @description:
 * @author: LRW
 * @create: 2024-02-26 22:12
 * @Version 1.0
 **/
@Setter
@Getter
public class PageBean<T> {
    private List<T> data;// 当前页的数据
    private int currPageSize; //当前页的数据
    private int currPage;// 当前页面
    private int totalPages;// 总页数
    private int totalNums;// 总条数
    private int pageSize;// 分页大小
}
