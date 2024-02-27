package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.entity.Admin;
import com.rw.quickcare.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName RoleMapper
 * @description:
 * @author: LRW
 * @create: 2024-02-26 22:23
 * @Version 1.0
 **/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
