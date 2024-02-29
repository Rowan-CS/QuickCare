package com.rw.quickcare.model.vo.hos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName TreeVo
 * @description:
 * @author: LRW
 * @create: 2024-02-28 22:37
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class DeptVo {
    private Integer id;
    private String name;
    private List<DeptVo> children;  //下级节点
}
