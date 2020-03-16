package com.lhb.friday.controller;

import com.lhb.friday.base.result.Results;
import com.lhb.friday.entity.SysRoleUser;
import com.lhb.friday.service.SysRoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysRoleUser)表控制层
 *
 * @author LHb
 * @since 2020-03-17 00:10:54
 */
@Controller
@RequestMapping("roleuser")
@Slf4j
public class SysRoleUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleUserService sysRoleUserService;

    @PostMapping("/getRoleUserByUserId")
    @ResponseBody
    public Results<SysRoleUser> getRoleUserByUserId(Integer userId) {
        log.info("getRoleUserByUserId（"+userId+"）");
        SysRoleUser sysRoleUser = sysRoleUserService.queryById(userId);
        if(sysRoleUser != null){
            return Results.success(sysRoleUser);
        }else{
            return Results.success();
        }
    }
}