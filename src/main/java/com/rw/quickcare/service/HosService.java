package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.hos.HosInsertVo;
import com.rw.quickcare.model.vo.hos.HosQueryDeptVo;
import com.rw.quickcare.model.vo.hos.HosQueryVo;

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

     PageBean<Hos> getByConsAndPage(HosQueryVo hosQueryVo, Integer currentPage);

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

     //根据id查医院基础信息
     HosInsertVo getHosSetInfo(Integer id);

     //查询所有医院（为了查询科室）
     List<HosQueryDeptVo> getAllHosToSelectDept();

     //根据
//     List<HosQueryDeptVo> getHosToSelectDept();

}
