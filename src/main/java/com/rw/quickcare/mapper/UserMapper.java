package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.rw.quickcare.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName UserMapper
 * @description:
 * @author: LRW
 * @create: 2024-02-28 16:34
 * @Version 1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //多条件查询普通用户
    List<User> selectUsersByCondition(@Param(Constants.WRAPPER) Wrapper queryWrapper);
}
