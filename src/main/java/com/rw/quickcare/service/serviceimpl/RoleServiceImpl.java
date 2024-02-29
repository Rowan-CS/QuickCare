package com.rw.quickcare.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.model.entity.Permission;
import com.rw.quickcare.model.entity.Role;
import com.rw.quickcare.mapper.PermissionMapper;
import com.rw.quickcare.mapper.RoleMapper;
import com.rw.quickcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName RoleServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-26 22:24
 * @Version 1.0
 **/
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updata(Role role) {

    }

    @Override
    public void disableById(Integer id) {
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id",id).set("role_status", 0);
        roleMapper.update(null,updateWrapper);
    }

    @Override
    public void enableById(Integer id) {
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id",id).set("role_status", 1);
        roleMapper.update(null,updateWrapper);
    }

    @Override
    public void changePerm(Integer id, List<Permission> permissions) {
//        roleMapper.se

    }


}
