package com.rw.quickcare.mapper;

import cn.hutool.core.lang.tree.Tree;
import com.alibaba.fastjson.JSON;
import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.vo.hos.HosQueryDeptVo;
import com.rw.quickcare.service.*;
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
//    @Autowired
//    private UserBackEndService userBackEndService;
//    @Autowired
//    private DeptService deptService;
//    @Autowired
//    private HosService hosService;
//    @Autowired
//    private DoctorScheduleService doctorScheduleService;
    @Test
    public void testSelect(){


//        System.out.println(doctorScheduleService.getSchemsByDeptAndPage(2,1));
    }
}
