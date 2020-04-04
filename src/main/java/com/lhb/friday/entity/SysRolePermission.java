package com.lhb.friday.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (SysRolePermission)实体类
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 831867609471181121L;
    
    private Integer roleId;
    
    private Integer permissionId;
}