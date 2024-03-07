package com.rw.quickcare.model.vo.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rw.quickcare.model.entity.Role;
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
 * @ClassName AdminList
 * @description:
 * @author: LRW
 * @create: 2024-02-28 18:04
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class AdminListVo {
    private Integer id;
    private String acc;
    private String psw;
    private String name;
    private String createTime;
    private String lastIp;
    private String lastTime;
    private Integer status;
    private Integer isDel;
    private Integer dataScope;
    private List<Role> roles;
}
