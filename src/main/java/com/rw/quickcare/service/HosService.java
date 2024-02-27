package com.rw.quickcare.service;

import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.vo.PageBean;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName HosService
 * @description:
 * @author: LRW
 * @create: 2024-02-26 21:16
 * @Version 1.0
 **/
public interface HosService {

     //查询所有医院
     PageBean<Hos> getAllHosByPage(Integer currentPage);

     //新增医院
     void addHos(Hos hos);

     //逻辑删除
     void delete(Integer hosId);

     //查询历史已删除
     PageBean<Hos> getAllDeleted(Integer currentPage);

     //从已删除记录中恢复
     void rerunById(Integer id);

     //更新医院信息
     void update(Hos hos);

     //锁定
     void block(Integer hosId);
     //取消锁定
     void unblock(Integer hosId);

}
