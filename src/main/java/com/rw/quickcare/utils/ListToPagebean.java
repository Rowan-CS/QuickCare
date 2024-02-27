package com.rw.quickcare.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.vo.PageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: quickcare
 * @ClassName ListToPage
 * @description:List集合进行分页并使用IPage接收
 * @author: LRW
 * @create: 2024-02-27 01:24
 * @Version 1.0
 **/
public class ListToPagebean {

    public static PageBean listToPagebean(List list, int pageNum, int pageSize){
        List pageList = new ArrayList<>();
        int curIdx = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
        for (int i = 0; i < pageSize && curIdx + i < list.size(); i++) {
            pageList.add(list.get(curIdx + i));
        }
        PageBean pageBean = new PageBean();
        pageBean.setData(pageList);
        pageBean.setCurrPage(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalNums(list.size());
        pageBean.setTotalPages((list.size() + pageSize -1) / pageSize);
        return pageBean;
    }

    public static PageBean iPageToPagebean(IPage iPage, int pageNum){
        PageBean pageBean = new PageBean();
        pageBean.setPageSize((int)iPage.getSize());
        pageBean.setData(iPage.getRecords());
        pageBean.setCurrPage(pageNum);
        pageBean.setTotalNums((int)iPage.getTotal());
        pageBean.setCurrPageSize(iPage.getRecords().size());
        pageBean.setTotalPages((int)iPage.getPages());
        return pageBean;
    }

}
