package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.entity.Admin;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.entity.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName Admin
 * @description:
 * @author: LRW
 * @create: 2024-02-26 18:00
 * @Version 1.0
 **/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    //根据管理员查所有权限
    List<Permission> getPermsById(Integer id);

    //根据管理员查其数据权限内所有医院
    List<Hos> getHosById(Integer id);

    //根据帐号和密码查管理员
    @Select("select * from admin where admin_acc=#{acc} and admin_psw=#{psw}")
    Admin getByAccAndPsw(@Param("acc") String acc, @Param("psw")String psw);
}
