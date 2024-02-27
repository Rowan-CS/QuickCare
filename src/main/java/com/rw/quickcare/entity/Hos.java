package com.rw.quickcare.entity;

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
    @NotBlank(message = "名字不能为空")
    @Size(min=3, max = 50, message = "名字字符长度必须为 3~50个")
    private String name;
    @TableField("hos_address")
    @NotBlank(message = "地址不能为空")
    @Size(min=3, max = 50, message = "地址字符长度必须为 3~50个")
    private String address;
    @TableField("hos_tele")
    @Pattern(regexp = "0\\d{2,3}-[1-9]\\d{6,7}", message = "联系电话格式错误")
    private String tele;
    @TableField("hos_intro")
    @NotBlank(message = "简介不能为空")
    @Size(min=3, max = 50, message = "简介字符长度必须为 3~200个")
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
