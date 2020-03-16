package com.lhb.friday.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * (SysRole)实体类
 *
 * @author LHb
 * @since 2020-03-16 12:20:41
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 305619269355940485L;
    
    private Integer id;
    
    private String name;
    
    private String description;
    
    private Date createtime;
    
    private Date updatetime;
}