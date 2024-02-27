package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.entity.Dept;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.mapper.HosMapper;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.utils.ListToPagebean;
import com.rw.quickcare.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName HosServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-26 21:16
 * @Version 1.0
 **/
@Service("HosService")
public class HosServiceImpl implements HosService {
    @Autowired
    private HosMapper hosMapper;

    @Override
    public PageBean<Hos> getAllHosByPage(Integer currentPage) {
        Page<Hos> page = new Page<>(currentPage, 10);
        QueryWrapper<Hos> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hos_isdelete",1);
        IPage<Hos> iPage = hosMapper.selectPage(page, queryWrapper);
        PageBean pageBean = ListToPagebean.iPageToPagebean(iPage, currentPage);
        return pageBean;
    }

    @Override
    public void addHos(Hos hos) {
        Long count = hosMapper.selectCount(new QueryWrapper<Hos>()
                .eq("hos_name",hos.getName()));
        if(count > 0){
            throw new BizException(BizExceptionCode.HOS_EXISTED);
        }else {
            hos.setCreateTime(DateUtil.now());
            hos.setIsDelete(1);
            hos.setStatus(1);
            hosMapper.insert(hos);
        }
    }

    @Override
    public void delete(Integer hosId) {
        UpdateWrapper<Hos> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hos_id",hosId).set("hos_isdelete", 0);
        hosMapper.update(null,updateWrapper);
    }

    @Override
    public PageBean<Hos> getAllDeleted(Integer currentPage) {
        Page<Hos> page = new Page<>(currentPage, 10);
        QueryWrapper<Hos> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hos_isdelete",0);
        IPage<Hos> iPage = hosMapper.selectPage(page, queryWrapper);
        PageBean pageBean = ListToPagebean.iPageToPagebean(iPage, currentPage);
        return pageBean;
    }

    @Override
    public void rerunById(Integer id) {
        UpdateWrapper<Hos> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hos_id",id).set("hos_isdelete",1);
        hosMapper.update(null,updateWrapper);
    }

    @Override
    public void update(Hos hos) {
        Long count = hosMapper.selectCount(new QueryWrapper<Hos>()
                .eq("hos_name",hos.getName()));
        if(count > 0){
            throw new BizException(BizExceptionCode.HOS_EXISTED);
        }else {
            hosMapper.updateById(hos);
        }
    }

    @Override
    public void block(Integer hosId) {
        UpdateWrapper<Hos> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hos_id",hosId).set("hos_status", 0);
        hosMapper.update(null,updateWrapper);
    }

    @Override
    public void unblock(Integer hosId) {
        UpdateWrapper<Hos> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hos_id",hosId).set("hos_status", 1);
        hosMapper.update(null,updateWrapper);
    }


}
