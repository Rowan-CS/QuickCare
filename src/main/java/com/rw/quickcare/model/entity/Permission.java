package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Permission
 * @description:
 * @author: LRW
 * @create: 2024-02-23 01:15
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@TableName(value = "permission")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Permission {
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer id;
    @TableField("permission_title")
    private String title;
    @TableField("permission_fid")
    private Integer fid;
    @TableField("permission_resources")
    private String resources;
    @TableField("permission_type")
    private String type;
    @TableField("permission_path")
    private String path;
    @TableField("permission_icon")
    private String icon;
    @TableField("permission_status")
    private Integer status;
//    @TableField(exist = false, select = false)
//    private List<Permission> children;


}
