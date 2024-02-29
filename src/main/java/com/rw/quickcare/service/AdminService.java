package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.Admin;

/**
 * @program: quickcare
 * @InterfaceName AdminService
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:11
 * @Version 1.0
 **/
public interface AdminService {

        Admin login(String acc, String psw);


}
