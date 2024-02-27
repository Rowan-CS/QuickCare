package com.rw.quickcare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName Patient
 * @description:
 * @author: LRW
 * @create: 2024-02-23 00:48
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class Patient {
    @TableId(value = "patient_id", type = IdType.AUTO)
    private Integer id;
    private String acc;
    private String psw;
    private String mobile;
    private String mail;
    private String birthDate;
    private Integer certiType;
    private Integer certiNo;
    private Integer status;
    private String createTime;

    private List<Patient> patients;
    private List<Reservation> reservations;
}
