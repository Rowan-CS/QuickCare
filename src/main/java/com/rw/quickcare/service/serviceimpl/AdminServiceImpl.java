package com.rw.quickcare.service.serviceimpl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeBuilder;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.net.NetUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.rw.quickcare.bizException.BizException;
import com.rw.quickcare.bizException.BizExceptionCode;
import com.rw.quickcare.model.entity.Admin;
import com.rw.quickcare.model.entity.Hos;
import com.rw.quickcare.model.entity.Permission;
import com.rw.quickcare.mapper.AdminMapper;
import com.rw.quickcare.mapper.HosMapper;
import com.rw.quickcare.model.vo.admin.AdminInfoVo;
import com.rw.quickcare.model.vo.hos.HosQueryDeptVo;
import com.rw.quickcare.model.vo.perm.ButtonsVo;
import com.rw.quickcare.model.vo.perm.MenusTreeVo;
import com.rw.quickcare.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: quickcare
 * @ClassName AdminServiceImpl
 * @description:
 * @author: LRW
 * @create: 2024-02-26 19:12
 * @Version 1.0
 **/
@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private HosMapper hosMapper;

    /***
     * @description: 管理员登录
     * @param: acc, psw
     * @return: com.rw.quickcare.entity.Admin
     * @author Lrw
     * @date: 2024/2/26 19:54
     */
    public Admin login(String acc, String psw) {
        QueryWrapper<Admin> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("admin_acc",acc).eq("admin_psw",psw);
        Admin admin = adminMapper.selectOne(queryWrapper);
        if (admin == null ){
            throw new BizException(BizExceptionCode.ADMIN_LOGIN_FAIL);
        } else if(admin.getStatus()==0){
            throw new BizException(BizExceptionCode.ADMIN_BLOCKED);
        } else if(admin.getIsDel()==0){
            throw new BizException(BizExceptionCode.ADMIN_DELETED);
        } else {
            return admin;
        }

    }

    @Override
    public AdminInfoVo getInfo(Integer id) {
        Admin admin = adminMapper.getInfoById(id);
        //1 更新用户上次登录时间和上次登录ip
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("admin_last_time", DateUtil.now()).set("admin_last_ip", NetUtil.getLocalhostStr())
                .eq("admin_id",id);
        adminMapper.update(null,updateWrapper);

        //3 医院数据权限只留id
        List<HosQueryDeptVo> datascope = new ArrayList<>();
        List<Hos> hos = admin.getHos();
        hos.forEach(h -> {
            datascope.add(new HosQueryDeptVo(h.getId(),h.getName()));
        });
        //2权限数据分类：将permission分为menu和button
        List<ButtonsVo> buttonVos = new ArrayList<>();
        List<MenusTreeVo> menuVos = new ArrayList<>();
            List<Permission> permissions = admin.getPermissions();
            permissions.forEach(perm -> {
                /*
                 * 如果权限是按钮，就添加到按钮里面
                 * */
                if (perm.getType().toLowerCase().equals("button")) {
                    buttonVos.add(new ButtonsVo(perm.getId(),perm.getFid(), perm.getResources(), perm.getTitle()));
                }
                /*
                 * 如果权限是菜单，就添加到菜单里面
                 * */
                if (perm.getType().toLowerCase().equals("menu")) {
                    menuVos.add(new MenusTreeVo(perm.getId(),perm.getTitle(), perm.getFid(), perm.getResources(),perm.getIcon(),null));
                }
            });
            //4 菜单转为树形
            TreeNodeConfig config = new TreeNodeConfig();
            config.setIdKey("id");                              //默认id，可以不设置
            config.setParentIdKey("fid");                       //父id
            config.setNameKey("title");                           //分类名称
            config.setWeightKey("fid");
            List<Tree<String>> treeList = TreeUtil.build(menuVos, "0", config, (object, treeNode) -> {
                treeNode.setId(String.valueOf(object.getId()));
//            treeNode.setName(object.getTitle());
                treeNode.setParentId(String.valueOf(object.getFid()));
                treeNode.putExtra("title", object.getTitle());
                treeNode.putExtra("resources", object.getResources());
                treeNode.putExtra("icon",object.getIcon());
            });
            AdminInfoVo adminInfoVo =
                    new AdminInfoVo(admin.getId(), admin.getName(),
                            admin.getRoles(), datascope,
                            buttonVos, treeList);
            return adminInfoVo;
        }

}
