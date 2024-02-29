package com.rw.quickcare.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rw.quickcare.model.entity.User;
import com.rw.quickcare.mapper.UserMapper;
import com.rw.quickcare.service.UserBackEndService;
import com.rw.quickcare.model.vo.PageBean;
import com.rw.quickcare.model.vo.user.UserListVo;
import com.rw.quickcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: quickcare
 * @ClassName UserBackEndServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-28 16:37
 * @Version 1.0
 **/
@Service("UserBackEndService")
public class UserBackEndServiceImpl implements UserBackEndService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageBean<User> getUsersByCondition(UserListVo userListVo, Integer curPage) {
        QueryWrapper queryWrapper = isConditon(userListVo);
        List<User> usersList = userMapper.selectUsersByCondition(queryWrapper);
        PageBean pageBean = DataUtils.listToPagebean(usersList, curPage, 10);
        return pageBean;
    }
    private QueryWrapper isConditon(UserListVo user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (user != null) {
            if (!user.getName().isEmpty() && user.getName()!=null ) {
                queryWrapper.like("user_name", user.getName());
            }
            if (user.getStatus() != null) {
                queryWrapper.eq("user_status", user.getStatus());
            }
            if (user.getCreateStartTime() != null) {
                queryWrapper.ge("user_create_time",user.getCreateStartTime());
            }
            if (user.getCreateEndTime() != null) {
                queryWrapper.le("user_create_time", user.getCreateEndTime());
            }
        }
        return queryWrapper;
    }

    @Override
    public void blockUserById(Integer userId) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userId).set("user_status", 0);
        userMapper.update(null,updateWrapper);
    }

    @Override
    public void unblockUserById(Integer userId) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userId).set("user_status", 1);
        userMapper.update(null,updateWrapper);
    }

    @Override
    public PageBean<User> getAll(Integer curPage) {
        List<User> users = userMapper.selectList(null);
        return DataUtils.listToPagebean(users,curPage,10);
    }
}
