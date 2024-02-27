package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Role
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:16
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Role {
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer id;
    @TableField("role_name")
    private String name;
    @TableField("role_status")
    private Integer status;
    @TableField("role_intro")
    private String intro;

    private List<Permission> permissions;
}
