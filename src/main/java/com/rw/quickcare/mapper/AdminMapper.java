package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.rw.quickcare.model.entity.*;
import com.rw.quickcare.model.vo.admin.AdminListVo;
import com.rw.quickcare.model.vo.admin.AdminQueryVo;
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

    //根据管理员id查角色
    Admin getInfoById(Integer id);

    //根据管理员查其数据权限内所有医院
    List<Hos> getHosById(Integer id);


    //多条件查询管理员用户
    List<AdminListVo> selectAdminsByCondition(AdminQueryVo admin);

}
