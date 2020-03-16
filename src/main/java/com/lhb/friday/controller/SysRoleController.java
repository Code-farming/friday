package com.lhb.friday.controller;

import com.lhb.friday.base.result.Results;
import com.lhb.friday.entity.SysRole;
import com.lhb.friday.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysRole)表控制层
 *
 * @author LHb
 * @since 2020-03-16 12:20:44
 */
@Controller
@RequestMapping("role")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    @GetMapping("all")
    @ResponseBody
    public Results<SysRole> getAll(){
        return sysRoleService.getAllRole();
    }


}