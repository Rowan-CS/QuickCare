package com.rw.quickcare.service;

import com.rw.quickcare.entity.Admin;
import com.rw.quickcare.entity.Hos;
import com.rw.quickcare.entity.Permission;
import com.rw.quickcare.vo.PageBean;

import java.util.List;

/**
 * @program: quickcare
 * @InterfaceName AdminService
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:11
 * @Version 1.0
 **/
public interface AdminService {

        Admin getByAccAndPsw(String acc, String psw);

        List<Permission> getPermsByAdminId(Integer adminId);

        PageBean<Hos> getHosByAdminIdAndPage(Integer adminId, Integer page);
}
