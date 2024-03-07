package com.rw.quickcare.model.vo.admin;

import cn.hutool.core.lang.tree.Tree;
import com.rw.quickcare.model.entity.Role;
import com.rw.quickcare.model.vo.hos.HosQueryDeptVo;
import com.rw.quickcare.model.vo.perm.ButtonsVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName AdminInfoVo
 * @description:
 * @author: LRW
 * @create: 2024-03-07 15:40
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInfoVo {
    private Integer id;
    private String name;
    private List<Role> roles;   //角色
    private List<HosQueryDeptVo> datascope;   //数据权限（医院id）
    private List<ButtonsVo> buttons;  //按钮
    private List<Tree<String>> menus;  //菜单

}
