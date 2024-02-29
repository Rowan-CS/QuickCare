package com.rw.quickcare.mapper;

import cn.hutool.core.net.NetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: quickcare
 * @ClassName MapperTest
 * @description:
 * @author: LRW
 * @create: 2024-02-26 18:03
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private AdminMapper adminMapper;



    @Test
    public void testSelect(){
        System.out.println("----- selectAll method test ------");
//        Admin admin = adminMapper.selectById(1);
//        List<Admin> admins = adminMapper.selectList(null);
//        Assert.isTrue(5 == adminList.size(), "");
//        adminList.forEach(System.out::println);
//        System.out.println(admins);
//        System.out.println(NetUtil.getLocalhostStr());



    }



}
