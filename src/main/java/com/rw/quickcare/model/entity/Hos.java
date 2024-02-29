package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @program: quickcare
 * @ClassName Hos
 * @description:
 * @author: LRW
 * @create: 2024-02-23 00:48
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Hos {
    @TableId(value = "hos_id", type = IdType.AUTO)
    private Integer id;
    @TableField("hos_name")
    private String name;
    @TableField("hos_level")
    private Integer level;
    @TableField("hos_address")
    private String address;
    @TableField("hos_tele")
    private String tele;
    @TableField("hos_intro")
    private String intro;
    @TableField("hos_status")
    private Integer status;
    @TableField("hos_create_time")
    private String createTime;
    @TableField("hos_isdelete")
    private Integer isDelete;

//    @TableField(exist = false, select = false)
//    private List<Admin> admins;

}
