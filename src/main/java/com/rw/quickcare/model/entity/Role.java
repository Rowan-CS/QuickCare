package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "角色名不能为空")
    @Size(min=3, max = 20, message = "名字字符长度为 3~20个")
    private String name;
    @TableField("role_status")
    private Integer status;
    @TableField("role_intro")
    @NotBlank(message = "角色描述不能为空")
    @Size(min=3, max = 50, message = "描述字符长度为 3~50个")
    private String intro;

    @TableField(exist = false, select = false)
    private List<Permission> permissions;
}
