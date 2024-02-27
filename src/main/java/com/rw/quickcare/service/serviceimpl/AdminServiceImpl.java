package com.rw.quickcare.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.entity.Admin;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.entity.Permission;
import com.rw.quickcare.mapper.AdminMapper;
import com.rw.quickcare.service.AdminService;
import com.rw.quickcare.utils.ListToPagebean;
import com.rw.quickcare.vo.PageBean;
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

    /***
     * @description: 根据帐号和密码查询管理员
     * @param: acc, psw
     * @return: com.rw.quickcare.entity.Admin
     * @author Lrw
     * @date: 2024/2/26 19:54
     */
    public Admin getByAccAndPsw(String acc, String psw) {
        Admin admin = adminMapper.getByAccAndPsw(acc, psw);
        if (admin == null){
            throw new BizException(BizExceptionCode.ADMIN_LOGIN_FAIL);
        } else if(admin.getStatus()==0){
            throw new BizException(BizExceptionCode.ADMIN_BLOCKED);
        } else if(admin.getIsDel()==0){
            throw new BizException(BizExceptionCode.ADMIN_DELETED);
        } else {
            return admin;
        }
    }

    /***
     * @description: 根据id查所有权限
     * @param: adminId
     * @return: java.util.List<com.rw.quickcare.entity.Permission>
     * @author Lrw
     * @date: 2024/2/26 23:08
     */
    @Override
    public List<Permission> getPermsByAdminId(Integer adminId) {
        List<Permission> perms = adminMapper.getPermsById(adminId);
        return perms;
    }

    @Override
    public PageBean<Hos> getHosByAdminIdAndPage(Integer adminId, Integer currentPage) {
        List<Hos> list = adminMapper.getHosById(adminId);
        PageBean<Hos> pageBean = ListToPagebean.listToPagebean(list, currentPage, 10);
        return pageBean;
    }
}
