package com.lhb.friday.service;

import com.lhb.friday.base.result.Results;
import com.lhb.friday.dto.SysUserDTO;
import com.lhb.friday.entity.SysUser;
import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author LHb
 * @since 2020-03-13 01:05:44
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有数据
     * @return 对象列表
     */
    List<SysUser> queryAllUser();


    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过 username 字段查找数据
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);

    /**
     * 通过 telephone 字段查找数据
     * @param telephone
     * @return
     */
    SysUser getUserByPhone(String telephone);


    /**
     * 通过 email 字段查找数据
     * @param email
     * @return
     */
    SysUser getUserByEmail(String email);


    Results save(SysUser sysUser, Integer roleId);

    Results<SysUser> updateUser(SysUserDTO userDto, Integer roleId);

    Results<SysUser> getUserByFuzzyUserName(String username, Integer offset, Integer limit);

}