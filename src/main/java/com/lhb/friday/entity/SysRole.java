package com.lhb.friday.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}