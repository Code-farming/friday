package com.lhb.friday.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * (SysUser)实体类
 *
 * @author LHb
 * @since 2020-03-13 01:05:42
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 958508190196471640L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String nickname;
    
    private String headImgUrl;
    
    private String phone;
    
    private String telephone;
    
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    private Integer sex;
    
    private Integer status;
    
    private Date createTime;
    
    private Date updateTime;
}