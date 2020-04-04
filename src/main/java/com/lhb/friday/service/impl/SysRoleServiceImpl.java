package com.lhb.friday.service.impl;

import com.lhb.friday.base.result.Results;
import com.lhb.friday.dao.SysRolePermissionDao;
import com.lhb.friday.dto.SysRoleDTO;
import com.lhb.friday.entity.SysRole;
import com.lhb.friday.dao.SysRoleDao;
import com.lhb.friday.entity.SysRolePermission;
import com.lhb.friday.service.SysRolePermissionService;
import com.lhb.friday.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRole)表服务实现类
 *
 * @author LHb
 * @since 2020-03-16 12:20:43
 */
@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Integer id) {
        return this.sysRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAllByLimit(int offset, int limit) {
        return this.sysRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole insert(SysRole sysRole) {
        this.sysRoleDao.insert(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole update(SysRole sysRole) {
        this.sysRoleDao.update(sysRole);
        return this.queryById(sysRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysRoleDao.deleteById(id) > 0;
    }

    @Override
    public Results<SysRole> getAllRole() {
        return Results.success(50, sysRoleDao.getAllRole());
    }

    @Override
    public Results<SysRole> getAllRolesByPage(Integer offset, Integer limit) {
        return Results.success(sysRoleDao.getCountRole(), sysRoleDao.getAllRolesByPage(offset, limit));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Results<SysRole> save(SysRoleDTO sysRoleDTO) {
        // 1.保存角色
        sysRoleDao.insert(sysRoleDTO);

        //2、保存角色对应的所有权限
        List<Long> permissionIds = sysRoleDTO.getPermissionIds();
        permissionIds.remove(0L);    // 移除0,permission id是从1开始
        if (!CollectionUtils.isEmpty(permissionIds)) {
            sysRolePermissionDao.save(sysRoleDTO.getId(), permissionIds);
        }

        return Results.success();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Results updateRole(SysRoleDTO sysRoleDTO) {
        List<Long> permissionIds = sysRoleDTO.getPermissionIds();
        permissionIds.remove(0L);
        sysRolePermissionDao.deleteRolePermission(sysRoleDTO.getId());

        if (!CollectionUtils.isEmpty(permissionIds)) {
            sysRolePermissionDao.save(sysRoleDTO.getId(), permissionIds);
        }

        int update = sysRoleDao.update(sysRoleDTO);
        if (update > 0) {
            return Results.success();
        } else {
            return Results.failure();
        }


    }
}