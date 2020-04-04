package com.lhb.friday.controller;

import com.lhb.friday.entity.SysRolePermission;
import com.lhb.friday.service.SysRolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysRolePermission)表控制层
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
@RestController
@RequestMapping("sysRolePermission")
public class SysRolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysRolePermissionService sysRolePermissionService;

}