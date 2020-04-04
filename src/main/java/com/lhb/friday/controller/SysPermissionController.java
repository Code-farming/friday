package com.lhb.friday.controller;

import com.alibaba.fastjson.JSONArray;
import com.lhb.friday.base.result.Results;
import com.lhb.friday.dto.SysRoleDTO;
import com.lhb.friday.entity.SysPermission;
import com.lhb.friday.service.SysPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysPermission)表控制层
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
@Controller
@RequestMapping("permission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysPermissionService sysPermissionService;

    @GetMapping("listAllPermission")
    @ResponseBody
    public Results<JSONArray> listAllPermission() {
        return sysPermissionService.listAllPermission();
    }

    @GetMapping("listAllPermissionByRoleId")
    @ResponseBody
    public Results<SysPermission> listAllPermissionByRoleId(SysRoleDTO sysRoleDTO) {
        return sysPermissionService.listByRoleId(sysRoleDTO.getId());
    }

}