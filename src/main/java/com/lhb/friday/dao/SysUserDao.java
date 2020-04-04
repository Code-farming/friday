package com.lhb.friday.dao;

import com.lhb.friday.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author LHb
 * @since 2020-03-13 01:05:43
 */
@Mapper
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询数据库中所有的用户
     * @return 对象列表
     */
    List<SysUser> queryAllUser();

    /**
     * 通过 username 查找用户
     * @param username
     * @return
     */
    SysUser getUserByUsername(String username);

    /**
     * 通过 telephone 查找用户
     * @param telephone
     * @return
     */
    SysUser getUserByPhone(String telephone);

    /**
     * 通过 email 查找用户
     * @param email
     * @return
     */
    SysUser getUserByEmail(String email);

    /**
     * 通过username模糊查询用户的数目
     * @param username
     * @return
     */
    Integer getUserCountByFuzzyUserName(String username);

    /**
     * 通过username进行模糊的分页查询
     * @param username
     * @param offset
     * @param limit
     * @return
     */
    List<SysUser> getUserPageByFuzzyUserName(@Param("username") String username, @Param("offset") Integer offset, @Param("limit") Integer limit);
}