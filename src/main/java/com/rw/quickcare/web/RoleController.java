package com.rw.quickcare.web;

import com.rw.quickcare.model.entity.ResponseEntity;
import com.rw.quickcare.model.entity.Role;
import com.rw.quickcare.service.PermissionService;
import com.rw.quickcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@CrossOrigin
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/getAll")
    public ResponseEntity delete(){
        List<Role> all = roleService.getAll();
        return new ResponseEntity("200",all);
    }

}
