package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.model.vo.admin.AdminListVo;
import com.rw.quickcare.model.vo.PageBean;

/**
 * @program: quickcare
 * @InterfaceName AdminBackEnd
 * @description:管理员用户管理
 * @author: LRW
 * @create: 2024-02-28 18:01
 * @Version 1.0
 **/
public interface AdminBackEndService {

    //分页查询所有管理员用户
    PageBean<Admin> getAll(Integer curPage);

    //分页多条件查询管理员用户
    PageBean<Admin> getByCondition(AdminListVo adminListVo, Integer curPage);

    //新增
    void add(Admin admin);
    //锁定
    void block(Integer id);
    //取消锁定
    void unblock(Integer id);


}
