package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "帐号不能为空")
    @Size(min=3, max = 20, message = "帐号字符长度必须为 3~20个")
    private String acc;
    @TableField("admin_psw")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{1,9}$", message = "密码须至少包含字母、数字，长度1-9位")
    private String psw;
    @TableField("admin_name")
    @NotBlank(message = "管理员名称不能为空")
    @Size(min=2, max = 20, message = "名称字符长度必须为 2~20个")
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
    @NotNull(message = "必须设置数据权限")
    private Integer dataScope;

    @TableField(exist = false, select = false)
    private List<Permission> permissions;  //功能权限
    @TableField(exist = false, select = false)
    private List<Hos> hos;  //数据权限
    @TableField(exist = false, select = false)
    private List<Role> roles; //角色
}
