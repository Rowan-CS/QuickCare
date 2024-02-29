package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.service.AdminBackEndService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quickcare
 * @ClassName AdminBackEndController
 * @description:
 * @author: LRW
 * @create: 2024-02-28 20:30
 * @Version 1.0
 **/
@Transactional
@RestController("adminmanagecontroller")
@RequestMapping("/api/v1/adminmanage")
public class AdminBackEndController {

    @Autowired
    private AdminBackEndService adminBackEndService;

    @RequestMapping("/select/{page}")
    public ResponseEntity select(@PathVariable Integer curPage){
        PageBean<Admin> pageBean = adminBackEndService.getAll(curPage);
        return new ResponseEntity("200",pageBean);
    }

    @RequestMapping("/add")
    public ResponseEntity add(@Validated @RequestBody Admin admin){
        adminBackEndService.add(admin);
        return new ResponseEntity("200","操作成功");
    }

    @RequestMapping("/block/{id}")
    public ResponseEntity block(@PathVariable Integer id){
        adminBackEndService.block(id);
        return new ResponseEntity("200","操作成功");
    }

    @RequestMapping("/unblock/{id}")
    public ResponseEntity unblock(@PathVariable Integer id){
        adminBackEndService.unblock(id);
        return new ResponseEntity("200","操作成功");
    }


}
