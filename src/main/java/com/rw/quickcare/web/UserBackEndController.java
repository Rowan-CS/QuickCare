package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.User;
import com.rw.quickcare.model.vo.user.UserListVo;
import com.rw.quickcare.model.vo.user.UserQueryVo;
import com.rw.quickcare.service.UserBackEndService;
import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/api/v1/adminuser")
public class UserBackEndController {

    @Autowired
    private UserBackEndService userBackEndService;

    @RequestMapping("/getAll")
    public ResponseEntity getAll(@PathVariable Integer page){
        PageBean<User> all = userBackEndService.getAll(page);
        return new ResponseEntity("200",all);
    }

    @PostMapping("/getByCon/{page}/{limit}")
    public ResponseEntity getByCon(@RequestBody UserQueryVo userQueryVo, @PathVariable Integer page,@PathVariable Integer limit){
        PageBean<User> pageBean = userBackEndService.getUsersByCondition(userQueryVo, page,limit);
        return new ResponseEntity("200",pageBean);
    }

}
