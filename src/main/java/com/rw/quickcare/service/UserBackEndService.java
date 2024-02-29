package com.rw.quickcare.service;

import com.rw.quickcare.model.entity.User;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.user.UserListVo;

/**
 * @program: quickcare
 * @InterfaceName UserBackEndService
 * @description:用户管理
 * @author: LRW
 * @create: 2024-02-28 16:37
 * @Version 1.0
 **/
public interface UserBackEndService {

    //多条件分页查询普通用户
    PageBean<User> getUsersByCondition(UserListVo userListVo, Integer curPage);

    //冻结用户
    void blockUserById(Integer userId);

    //取消冻结
    void unblockUserById(Integer userId);

    //分页查所有普通用户
    PageBean<User> getAll(Integer curPage);

}
