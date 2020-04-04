package com.lhb.friday.controller;

import com.lhb.friday.base.result.PageTableRequest;
import com.lhb.friday.base.result.Results;
import com.lhb.friday.dto.SysRoleDTO;
import com.lhb.friday.dto.SysUserDTO;
import com.lhb.friday.entity.SysRole;
import com.lhb.friday.entity.SysUser;
import com.lhb.friday.service.SysRoleService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * 查询所有的角色信息,在用户的编辑页面被调用
     *
     * @return
     */
    @GetMapping("all")
    @ResponseBody
    public Results<SysRole> getAll() {
        return sysRoleService.getAllRole();
    }

    /**
     * 分页查找 角色列表
     *
     * @param request
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Results<SysRole> list(PageTableRequest request) {
        request.countOffset();
        return sysRoleService.getAllRolesByPage(request.getOffset(), request.getLimit());
    }

    @GetMapping("add")
    public String addRole(Model model) {
        model.addAttribute("sysRole", new SysRole());
        return "role/role-add";
    }

    @PostMapping("add")
    @ResponseBody
    public Results saveRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return sysRoleService.save(sysRoleDTO);
    }

    @GetMapping("edit")
    public String editRole(Model model,SysRole sysRole) {
        model.addAttribute("sysRole", sysRoleService.queryById(sysRole.getId()));
        return "role/role-edit";
    }

    @PostMapping("edit")
    @ResponseBody
    public Results updateRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return sysRoleService.updateRole(sysRoleDTO);
    }

    String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat(pattern),true));
    }

}