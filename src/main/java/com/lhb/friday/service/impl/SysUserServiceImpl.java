package com.lhb.friday.service.impl;

import com.lhb.friday.base.result.Results;
import com.lhb.friday.dao.SysRoleUserDao;
import com.lhb.friday.dao.SysUserDao;
import com.lhb.friday.entity.SysRoleUser;
import com.lhb.friday.entity.SysUser;
import com.lhb.friday.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author LHb
 * @since 2020-03-13 01:05:44
 */
@Service("sysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysRoleUserDao sysRoleUserDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<SysUser> queryAllUser() {
        return sysUserDao.queryAllUser();
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    /**
     * 通过用户的姓名查找用户
     * @param username
     * @return 实体对象
     */
    @Override
    public SysUser getUserByUsername(String username) {
        return sysUserDao.getUserByUsername(username);
    }

    /**
     * 通过用户的电话查找用户
     * @param telephone
     * @return 实体对象
     */
    @Override
    public SysUser getUserByPhone(String telephone) {
        return sysUserDao.getUserByPhone(telephone);
    }

    @Override
    public SysUser getUserByEmail(String email) {
        return sysUserDao.getUserByEmail(email);
    }

    @Override
    public Results save(SysUser sysUser, Integer roleId) {
        if (roleId != null){
            sysUserDao.insert(sysUser);
            SysRoleUser sysRoleUser = new SysRoleUser();
            sysRoleUser.setRoleId(roleId);
            sysRoleUser.setUserId(sysUser.getId());
            sysRoleUserDao.insert(sysRoleUser);
            return Results.success();
        }
        return Results.failure();
    }

}