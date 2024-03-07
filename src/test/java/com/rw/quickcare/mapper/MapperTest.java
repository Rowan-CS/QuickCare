package com.rw.quickcare.mapper;

import cn.hutool.core.net.NetUtil;
import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.model.entity.Reservation;
import com.rw.quickcare.model.vo.admin.AdminListVo;
import com.rw.quickcare.model.vo.admin.AdminQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationCountQueryVo;
import com.rw.quickcare.model.vo.reservation.ReservationCountVo;
import com.rw.quickcare.model.vo.reservation.ReservationQueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
//    @Autowired
//    private ReservationMapper reservationMapper;


    @Test
    public void testSelect(){
        System.out.println("----- selectAll method test ------");

        Admin admin = adminMapper.getInfoById(1);
        System.out.println("---------------医院有：----------------");
        System.out.println(admin.getHos());
        System.out.println("---------------角色有：----------------");
        System.out.println(admin.getRoles());
        System.out.println("---------------权限有：----------------");
        System.out.println(admin.getPermissions());
    }



}
