package com.rw.quickcare.model.vo.perm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName PermissionTreeVo
 * @description:
 * @author: LRW
 * @create: 2024-03-07 15:44
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenusTreeVo {
    private Integer id;
    private String title;
    private Integer fid;
    private String resources;
    private String icon;
    private List<MenusTreeVo> children;


}
