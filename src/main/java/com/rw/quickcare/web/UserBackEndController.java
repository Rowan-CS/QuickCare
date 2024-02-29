package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.User;
import com.rw.quickcare.service.UserBackEndService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.user.UserListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quickcare
 * @ClassName UserBackEndController
 * @description:
 * @author: LRW
 * @create: 2024-02-28 17:48
 * @Version 1.0
 **/
@Transactional
@RestController("adminusercontroller")
@RequestMapping("/api/v1/adminuser")
public class UserBackEndController {

    @Autowired
    private UserBackEndService userBackEndService;

    @RequestMapping("/getAll")
    public ResponseEntity getAll(@PathVariable Integer page){
        PageBean<User> all = userBackEndService.getAll(page);
        return new ResponseEntity("200",all);
    }

    @RequestMapping("/getByCon")
    public ResponseEntity getByCon(@RequestBody UserListVo userListVo, @PathVariable Integer page){
        PageBean<User> pageBean = userBackEndService.getUsersByCondition(userListVo, page);
        return new ResponseEntity("200",pageBean);
    }

}
