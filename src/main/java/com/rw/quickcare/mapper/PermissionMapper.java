package com.rw.quickcare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rw.quickcare.model.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: quickcare
 * @InterfaceName PermissionMapper
 * @description:
 * @author: LRW
 * @create: 2024-02-28 20:45
 * @Version 1.0
 **/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
