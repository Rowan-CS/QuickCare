package com.rw.quickcare.model.vo.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String acc;
    private String psw;
}
