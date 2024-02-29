package com.rw.quickcare.web;

import com.rw.quickcare.service.PermissionService;
import com.rw.quickcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quickcare
 * @ClassName RoleController
 * @description:
 * @author: LRW
 * @create: 2024-02-28 22:27
 * @Version 1.0
 **/
@Transactional
@RestController("rolecontroller")
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


}
