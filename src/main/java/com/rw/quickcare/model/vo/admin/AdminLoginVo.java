package com.rw.quickcare.model.vo.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @program: quickcare
 * @ClassName AdminLoginVo
 * @description:
 * @author: LRW
 * @create: 2024-02-26 20:57
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class AdminLoginVo {
    @NotBlank(message = "名字不能为空")
    @Size(min=2, max = 20, message = "名字字符长度必须为 2~20个")
    private String acc;
    @NotBlank(message = "密码不能为空")
    @Size(min=5, max = 25, message = "密码字符长度必须为 5~25个")
    private String psw;
}
