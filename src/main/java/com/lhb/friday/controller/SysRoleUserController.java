package com.lhb.friday.controller;

import com.lhb.friday.service.SysRoleUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SysRoleUser)表控制层
 *
 * @author LHb
 * @since 2020-03-16 12:37:57
 */
@RestController
@RequestMapping("sysRoleUser")
public class SysRoleUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleUserService sysRoleUserService;

}