package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.model.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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

    @Insert("insert role (datetime,way,orderId,project,fee,status,wallet_id) values(#{datetime},#{way},#{orderId},#{project},#{fee},#{status},#{walletid})")
    @Options(useGeneratedKeys = true,keyColumn = "role_id",keyProperty = "id")
    void add(Role role);

}
