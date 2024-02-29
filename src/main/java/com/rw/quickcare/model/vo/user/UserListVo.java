package com.rw.quickcare.model.vo.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: quickcare
 * @ClassName UserListVo
 * @description:
 * @author: LRW
 * @create: 2024-02-28 17:14
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class UserListVo {
    private String name;
    private Integer status;
    private Integer createStartTime;
    private Integer createEndTime;

}
