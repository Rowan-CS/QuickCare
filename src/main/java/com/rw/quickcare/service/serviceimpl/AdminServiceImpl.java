package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.NetUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.entity.Permission;
import com.rw.quickcare.mapper.AdminMapper;
import com.rw.quickcare.mapper.HosMapper;
import com.rw.quickcare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName AdminServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:12
 * @Version 1.0
 **/
@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private HosMapper hosMapper;

    /***
     * @description: 管理员登录
     * @param: acc, psw
     * @return: com.rw.quickcare.entity.Admin
     * @author Lrw
     * @date: 2024/2/26 19:54
     */
    public Admin login(String acc, String psw) {
        Admin admin = adminMapper.getByAccAndPsw(acc, psw);
        if (admin == null){
            throw new BizException(BizExceptionCode.ADMIN_LOGIN_FAIL);
        } else if(admin.getStatus()==0){
            throw new BizException(BizExceptionCode.ADMIN_BLOCKED);
        } else if(admin.getIsDel()==0){
            throw new BizException(BizExceptionCode.ADMIN_DELETED);
        }
        //登录成功：1 更新用户上次登录时间和上次登录ip
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("admin_last_time", DateUtil.now()).set("admin_last_ip", NetUtil.getLocalhostStr())
                .eq("hos_id",admin.getId());
        adminMapper.update(null,updateWrapper);
        // 3 获取数据和功能权限
        List<Permission> perms = adminMapper.getPermsById(admin.getId());
        admin.setPermissions(perms);
        //3.1 获取数据权限
        List<Hos> hosList;
        if (admin.getDataScope()==1){
            //3.1.1 系统管理员可查所有医院
            hosList = hosMapper.selectList(null);
        } else {
            //3.1.2 医院管理员查部分医院
            hosList = adminMapper.getHosById(admin.getId());
        }
        admin.setHos(hosList);
        return admin;
    }

}
