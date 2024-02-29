package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.mapper.AdminMapper;
import com.rw.quickcare.service.AdminBackEndService;
import com.rw.quickcare.model.vo.admin.AdminListVo;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName AdminBackEndImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-28 18:01
 * @Version 1.0
 **/
@Service("AdminBackEndService")
public class AdminBackEndImpl implements AdminBackEndService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public PageBean<Admin> getAll(Integer curPage) {
        List<Admin> admins = adminMapper.selectList(null);
        PageBean pageBean = DataUtils.listToPagebean(admins, curPage, 10);
        return pageBean;
    }

    @Override
    public PageBean<Admin> getByCondition(AdminListVo adminListVo, Integer curPage) {

        return null;
    }

    @Override
    public void add(Admin admin) {
        admin.setCreateTime(DateUtil.now());
        admin.setStatus(1);
        admin.setIsDel(1);
        adminMapper.insert(admin);
    }

    @Override
    public void block(Integer id) {
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("admin_id",id).set("admin_status", 0);
        adminMapper.update(null,updateWrapper);
    }

    @Override
    public void unblock(Integer id) {
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("admin_id",id).set("admin_status", 1);
        adminMapper.update(null,updateWrapper);
    }
}
