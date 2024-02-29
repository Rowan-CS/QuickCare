package com.rw.quickcare.mapper;

import com.alibaba.fastjson.JSON;
import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.vo.hos.DeptVo;
import com.rw.quickcare.service.AdminService;
import com.rw.quickcare.service.DeptService;
import com.rw.quickcare.service.HosService;
import com.rw.quickcare.service.UserBackEndService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName AdminTest
 * @description:
 * @author: LRW
 * @create: 2024-02-26 23:17
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserBackEndService userBackEndService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private HosService hosService;
    @Test
    public void testSelect(){
//        List<Permission> perms = adminService.getPermsByAdminId(2);
//        List<Hos> hos = adminService.getHosByAdminIdAndPage(1,2);
//        System.out.println(hos);

//        System.out.println(perms);

//        Admin admin = adminService.getByAccAndPsw("TOM", "tom123");
//        System.out.println(admin);
//        UserListVo user = new UserListVo();
//        user.setName("A");
//        PageBean<User> data = userBackEndService.getUsersByCondition(user,1);
//        System.out.println(data);
        hosService.block(1);

    }
}
