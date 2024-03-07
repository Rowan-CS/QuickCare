package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.mapper.HosMapper;
import com.rw.quickcare.model.entity.Dept;
import com.rw.quickcare.model.entity.Doctor;
import com.rw.quickcare.mapper.DeptMapper;
import com.rw.quickcare.mapper.DoctorMapper;
import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: quickcare
 * @ClassName DeptServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-27 14:58
 * @Version 1.0
 **/
@Service("DeptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private HosMapper hosMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Dept> getByHosId(Integer hosId) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hos_id", hosId);
        List<Dept> depts = deptMapper.selectList(queryWrapper);
        return depts;
    }

    @Override
    public void add(Dept dept) {
        Long count = deptMapper.selectCount(new QueryWrapper<Dept>()
                .eq("hos_id", dept.getHosId())
                .eq("dept_name", dept.getName()));
        if (count > 0) {
            throw new BizException(BizExceptionCode.DEPT_EXISTED);
        } else {
            dept.setStatus(1);
            deptMapper.insert(dept);
        }
    }

    @Override
    public void delete(Integer id) {
        //删除条件：1 查询该部门没有二级科室
        QueryWrapper<Dept> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("dept_fid", id);
        List<Dept> conditionDept = deptMapper.selectList(queryWrapper1);
        //删除条件：2 查询该部门没有关联医生
        QueryWrapper<Doctor> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("dept_id", id);
        List<Doctor> conditionDoc = doctorMapper.selectList(queryWrapper2);
        //满足两个删除条件
        if (conditionDept.size() == 0 && conditionDoc.size() == 0) {
            deptMapper.deleteById(id);
        } else {
            throw new BizException(BizExceptionCode.DELETE_DEPT_FAIL);
        }
    }

    @Override
    public void update(Dept dept) {
        Long count = deptMapper.selectCount(new QueryWrapper<Dept>()
                .eq("hos_id", dept.getHosId())
                .eq("dept_name", dept.getName()));
        if (count > 0) {
            throw new BizException(BizExceptionCode.DEPT_EXISTED);
        } else {
            deptMapper.updateById(dept);
        }
    }

    @Override
    public void block(Integer id) {
        UpdateWrapper<Dept> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("dept_id", id).set("dept_status", 0);
        deptMapper.update(null, updateWrapper);
    }

    @Override
    public void unblock(Integer id) {
        UpdateWrapper<Dept> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("dept_id", id).set("dept_status", 1);
        deptMapper.update(null, updateWrapper);
    }

    @Override
    public List<Tree<String>> getDeptTree(Integer hosId) {
        //1.获取医院所有科室信息
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hos_id", hosId);
        List<Dept> deptList = deptMapper.selectList(queryWrapper);
        //2.配置
        TreeNodeConfig config = new TreeNodeConfig();
        config.setIdKey("id");                              //默认id，可以不设置
        config.setParentIdKey("fid");                       //父id
        config.setNameKey("name");                           //分类名称
        config.setDeep(2);                                  //最大递归深度
        config.setWeightKey("id");
        //3.转树
        List<Tree<String>> treeList = TreeUtil.build(deptList, "0", config, (object, treeNode) -> {
            treeNode.setId(String.valueOf(object.getId()));
            treeNode.setName(object.getName());
            treeNode.setParentId(String.valueOf(object.getFid()));
            treeNode.putExtra("location", object.getLocation());
            treeNode.putExtra("intro",object.getIntro());
            treeNode.putExtra("status", String.valueOf(object.getStatus()));
        });
        return treeList;
    }}



