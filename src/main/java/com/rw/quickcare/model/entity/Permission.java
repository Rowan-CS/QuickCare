package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Builder
public class Permission {
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer id;
    @TableField("permission_name")
    private String name;
    @TableField("permission_fid")
    private Integer fid;
    @TableField("permission_url")
    private String url;
    @TableField("permission_status")
    private Integer status;
    @TableField("permission_code")
    private String code;

}
