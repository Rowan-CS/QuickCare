package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.Dept;
import com.rw.quickcare.model.entity.Doctor;
import com.rw.quickcare.mapper.DeptMapper;
import com.rw.quickcare.mapper.DoctorMapper;
import com.rw.quickcare.model.vo.hos.DeptVo;
import com.rw.quickcare.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        //创建List集合，用于最终数据封装
        List<DeptVo> result = new ArrayList<>();

        //根据医院编号，查询所有科室信息
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hos_id", hosId);
        List<Dept> deptList = deptMapper.selectList(queryWrapper);
        return null;
    }}

//        List<Dept> pDept =
//                deptList.stream().filter(dept -> dept.getFid()==null).collect(Collectors.toList());
//        for(Dept dept : pDept){
//
//        }
//        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
//        treeNodeConfig.setIdKey("id");
//        treeNodeConfig.setParentIdKey("fid");
//        treeNodeConfig.setNameKey("name");
//
//        List<Tree<String>> treeList = TreeUtil.build(deptList, "0", treeNodeConfig, (map, tree) -> {
//            tree.setId(String.valueOf(map.getId()));
//            tree.setName(map.getName());
//            tree.setParentId(String.valueOf(map.getFid()));
//        });
//        return treeList;
//    }

//        //根据大科室编号bigcode进行分组，获取每个大科室里面的下级子科室
//        Map<Integer, List<Dept>> departmentMap =
//                depts.stream().collect(Collectors.groupingBy(x -> Optional.ofNullable(x.getFid()).orElse(0)));
//        //遍历map集合
//        for(Map.Entry<Integer,List<Dept>> entry : departmentMap.entrySet()){
//            //大科室编号
//            Integer bigcode = entry.getKey();
//            //大科室编号对应的全部数据
//            List<Dept> department1List = entry.getValue();
//
//            //封装大科室
//            DeptVo departmentVo1 = new DeptVo();
//            departmentVo1.setId(bigcode);
//            departmentVo1.setName(department1List.get(0).getName());
//            //封装小科室
//            List<DeptVo> children = new ArrayList<>();
//            for(Dept department : department1List){
//                DeptVo departmentVo2 = new DeptVo();
//                departmentVo2.setId(department.getId());
//                departmentVo2.setName(department.getName());
//                //封装到List集合
//                children.add(departmentVo2);
//            }
//            //把小科室list集合放到大科室children里面
//            departmentVo1.setChildren(children);
//
//            //放到最终result里面
//            result.add(departmentVo1);
//        }
//        return result;


