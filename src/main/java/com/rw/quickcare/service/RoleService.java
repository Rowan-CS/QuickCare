package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Permission;
import com.rw.quickcare.model.entity.Role;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName RoleService
 * @description:
 * @author: LRW
 * @create: 2024-02-26 22:24
 * @Version 1.0
 **/
public interface RoleService  {

    //查所有角色列表
    List<Role> getAll();

    //新增角色
    void add(Role role);
    //修改角色
    void updata(Role role);
    //角色不可用
    void disableById(Integer id);
    //角色恢复可用
    void enableById(Integer id);
    //为角色修改权限
    void changePerm(Integer id, List<Permission> permissions);

    //根据角色id查所有功能权限
//    List<Permission>
}
