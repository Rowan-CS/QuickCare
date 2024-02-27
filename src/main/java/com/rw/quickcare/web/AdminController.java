package com.rw.quickcare.web;

import com.rw.quickcare.entity.Admin;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.service.AdminService;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.vo.AdminLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.rw.quickcare.unityhandler.ResponseEntity;
import java.util.List;


/**
 * @program: quickcare
 * @ClassName AdminController
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:15
 * @Version 1.0
 **/
@Transactional
@RestController("admincontroller")
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private HosService hosService;

    /***
     * @description: 管理员登录
     * @param: adminLoginVo
     * @return: admin
     * @author Lrw
     * @date: 2024/2/26 20:59
     */
    @RequestMapping("/login/{page}")
    public ResponseEntity login(@RequestBody AdminLoginVo adminLoginVo, @PathVariable Integer page){
        //1 校验帐号密码
        Admin admin = adminService.getByAccAndPsw(adminLoginVo.getAcc(), adminLoginVo.getPsw());
        //2 管理员授权
        //2.1 功能（菜单）权限
        admin.setPermissions(adminService.getPermsByAdminId(admin.getId()));
        //2.2数据权限
            if (admin.getDataScope()==1){
                //2.2.1系统管理员可查所有医院
                List<Hos> hosList = hosService.getAllHosByPage(page).getData();
                admin.setHos(hosList);
            } else {
                //2.2 医院管理员查部分医院
                admin.setHos(adminService.getHosByAdminIdAndPage(admin.getId(), page).getData());
            }
        return new ResponseEntity("200","登录成功",admin);
    }


}
