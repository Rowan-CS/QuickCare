package com.rw.quickcare.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName User
 * @description:
 * @author: LRW
 * @create: 2024-02-23 00:48
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_acc")
    private String acc;
    @TableField("user_psw")
    private String psw;
    @TableField("user_name")
    private String name;
    @TableField("user_mobile")
    private String mobile;
    @TableField("user_mail")
    private String mail;
    @TableField("user_birthdate")
    private String birthDate;
    @TableField("user_certi_type")
    private Integer certiType;
    @TableField("user_certi_no")
    private Integer certiNo;
    @TableField("user_status")
    private Integer status;
    @TableField("user_create_time")
    private String createTime;

    @TableField(exist = false, select = false)
    private List<Patient> patients;
    @TableField(exist = false, select = false)
    private List<Reservation> reservations;
}
