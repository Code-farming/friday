package com.lhb.friday.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.lhb.friday.base.result.Results;
import com.lhb.friday.entity.SysPermission;
import com.lhb.friday.dao.SysPermissionDao;
import com.lhb.friday.service.SysPermissionService;
import com.lhb.friday.util.TreeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermission)表服务实现类
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermission queryById(Integer id) {
        return this.sysPermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermission> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission insert(SysPermission sysPermission) {
        this.sysPermissionDao.insert(sysPermission);
        return sysPermission;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission update(SysPermission sysPermission) {
        this.sysPermissionDao.update(sysPermission);
        return this.queryById(sysPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysPermissionDao.deleteById(id) > 0;
    }

    /**
     * 展示所有的权限
     * @return
     */
    @Override
    public Results<JSONArray> listAllPermission() {
        List<SysPermission> datas = sysPermissionDao.findAll();
        JSONArray array = new JSONArray();
        TreeUtils.setPermissionsTree(0, datas, array);
        return Results.success(array);
    }

    /**
     * 通过角色Id展示权限
     * @param roleId
     * @return
     */
    @Override
    public Results<SysPermission> listByRoleId(Integer roleId) {
        return Results.success(0,sysPermissionDao.listByRoleId(roleId));
    }
}