package com.lhb.friday.entity;

import java.io.Serializable;
import lombok.Data;
/**
 * (SysPermission)实体类
 *
 * @author LHb
 * @since 2020-04-04 20:15:34
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -80392096383388806L;
    
    private Integer id;
    
    private Integer parentId;
    
    private String name;
    
    private String css;
    
    private String href;
    
    private Integer type;
    
    private String permission;
    
    private Integer sort;
}