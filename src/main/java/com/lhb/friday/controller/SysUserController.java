package com.lhb.friday.controller;

import com.lhb.friday.base.result.PageTableRequest;
import com.lhb.friday.base.result.ResponseCode;
import com.lhb.friday.base.result.Results;
import com.lhb.friday.dto.SysUserDTO;
import com.lhb.friday.entity.SysUser;
import com.lhb.friday.service.SysUserService;
import com.lhb.friday.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author LHb
 * @since 2020-03-13 01:05:44
 */
@Controller
@RequestMapping("user")
@Slf4j
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public SysUser selectOne(Integer id) {
        return this.sysUserService.queryById(id);
    }

    /**
     * 分页查询用户的数据
     * @param tableRequest
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Results<SysUser> getUserList(PageTableRequest tableRequest) {
        tableRequest.countOffset();
        List<SysUser> userList = sysUserService.queryAllByLimit(tableRequest.getOffset(),tableRequest.getLimit());
        List<SysUser> allUser = sysUserService.queryAllUser();
        int count = allUser.size();
        return Results.success("获取数据成功", count, userList);
    }

    /**
     * 跳转到新增用户页面
     * @param model
     * @return
     */
    @GetMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("sysUser",new SysUser());
        return "user/user-add";
    }

    /**
     * 新增用户
     * @param sysUserDTO
     * @param roleId
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Results saveUser(SysUserDTO sysUserDTO, Integer roleId) {
        SysUser sysUser = null;
        sysUser=sysUserService.getUserByUsername(sysUserDTO.getUsername());
        if(sysUser != null && !(sysUser.getId().equals(sysUserDTO.getId()))){
            return Results.failure(ResponseCode.USERNAME_REPEAT.getCode(),ResponseCode.USERNAME_REPEAT.getMessage());
        }
        sysUser = sysUserService.getUserByPhone(sysUserDTO.getTelephone());
        if(sysUser != null && !(sysUser.getId().equals(sysUserDTO.getId()))){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }
        sysUser = sysUserService.getUserByEmail(sysUserDTO.getEmail());
        if(sysUser != null && !(sysUser.getId().equals(sysUserDTO.getId()))){
            return Results.failure(ResponseCode.EMAIL_REPEAT.getCode(),ResponseCode.EMAIL_REPEAT.getMessage());
        }
        //设置用户的初始状态为1
        sysUserDTO.setStatus(1);
//      sysUserDTO.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        //对用户的密码进行MD5加密
        sysUserDTO.setPassword(MD5.crypt(sysUserDTO.getPassword()));
        //保存用户
        return sysUserService.save(sysUserDTO,roleId);
    }

    String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder,WebRequest request){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat(pattern),true));
    }

    /**
     * 跳转到编辑用户的页面
     * @param model
     * @param user
     * @return
     */
    @GetMapping(value = "/edit")
    public String editUser(Model model, SysUser user) {
        model.addAttribute("sysUser",sysUserService.queryById(user.getId()));
        return "user/user-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    public Results<SysUser> updateUser( SysUserDTO userDto,Integer roleId) {
        SysUser sysUser = null;
        sysUser = sysUserService.getUserByUsername(userDto.getUsername());
        if(sysUser != null && !(sysUser.getId().equals(userDto.getId()))){
            return Results.failure(ResponseCode.USERNAME_REPEAT.getCode(),ResponseCode.USERNAME_REPEAT.getMessage());
        }
        sysUser = sysUserService.getUserByPhone(userDto.getTelephone());
        if(sysUser != null && !(sysUser.getId().equals(userDto.getId()))){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }
        sysUser = sysUserService.getUserByEmail(userDto.getEmail());
        if(sysUser != null && !(sysUser.getId().equals(userDto.getId()))){
            return Results.failure(ResponseCode.EMAIL_REPEAT.getCode(),ResponseCode.EMAIL_REPEAT.getMessage());
        }
        return sysUserService.updateUser(userDto,roleId);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public Results<SysUser> deleteUser( SysUserDTO userDto) {
        sysUserService.deleteById(userDto.getId());
        return Results.success();
    }


    @RequestMapping("/findUserByFuzzyUserName")
    @ResponseBody
    public Results<SysUser> findUserByFuzzyUserName(PageTableRequest tableRequest,String username) {
        tableRequest.countOffset();
        return sysUserService.getUserByFuzzyUserName(username,tableRequest.getOffset(),tableRequest.getLimit());
    }

}