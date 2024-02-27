package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Admin
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:11
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@TableName("admin")
public class Admin {
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "admin_acc")
    private String acc;
    @TableField("admin_psw")
    private String psw;
    @TableField("admin_name")
    private String name;
    @TableField("admin_create_time")
    private String createTime;
    @TableField("admin_last_ip")
    private String lastIp;
    @TableField("admin_last_time")
    private String lastTime;
    @TableField("admin_status")
    private Integer status;
    @TableField("admin_isdel")
    private Integer isDel;
    @TableField("admin_datascope")
    private Integer dataScope;

    @TableField(exist = false, select = false)
    private List<Permission> permissions;  //功能权限
    @TableField(exist = false, select = false)
    private List<Hos> hos;  //数据权限
}
