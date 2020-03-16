package com.lhb.friday.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (SysRoleUser)实体类
 *
 * @author LHb
 * @since 2020-03-16 12:37:57
 */
@Data
public class SysRoleUser implements Serializable {
    private static final long serialVersionUID = -57542296005145374L;
    
    private Integer userId;
    
    private Integer roleId;
}