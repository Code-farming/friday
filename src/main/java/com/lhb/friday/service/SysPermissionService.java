package com.lhb.friday.service;

import com.alibaba.fastjson.JSONArray;
import com.lhb.friday.base.result.Results;
import com.lhb.friday.entity.SysPermission;

import java.util.List;

/**
 * (SysPermission)表服务接口
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
public interface SysPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermission queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission insert(SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    SysPermission update(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Results<JSONArray> listAllPermission();

    Results<SysPermission> listByRoleId(Integer roleId);
}