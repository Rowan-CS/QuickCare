package com.rw.quickcare.web;

import cn.hutool.core.lang.tree.Tree;
import com.rw.quickcare.model.entity.Dept;
import com.rw.quickcare.model.vo.hos.HosQueryDeptVo;
import com.rw.quickcare.service.DeptService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.service.HosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: quickcare
 * @ClassName DeptController
 * @description:
 * @author: LRW
 * @create: 2024-02-27 15:23
 * @Version 1.0
 **/
@Transactional
@RestController("deptcontroller")
@RequestMapping("/api/v1/dept")
@CrossOrigin
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private HosService hosService;

    @RequestMapping("/selectByHos/{hosId}")
    public ResponseEntity selectByHos(@PathVariable Integer hosId){
        List<Tree<String>> deptTree = deptService.getDeptTree(hosId);
        return new ResponseEntity("200","查询成功",deptTree);
    }
    @RequestMapping("/getHos")
    public ResponseEntity selectHos(){
        List<HosQueryDeptVo> hosList = hosService.getAllHosToSelectDept();
        return new ResponseEntity("200","查询成功",hosList);
    }


    @RequestMapping("/add/{hosId}")
    public ResponseEntity add(@Validated @RequestBody Dept dept, @PathVariable Integer hosId){
        dept.setHosId(hosId);
        deptService.add(dept);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        deptService.delete(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/update/{id}")
    public ResponseEntity update(@Validated @RequestBody Dept dept,@PathVariable Integer id){
        dept.setId(id);
        deptService.update(dept);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/block/{id}")
    public ResponseEntity block(@PathVariable Integer id){
        deptService.block(id);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/unblock/{id}")
    public ResponseEntity unblock(@PathVariable Integer id){
        deptService.unblock(id);
        return ResponseEntity.SUCCESS;
    }

}
