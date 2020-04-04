package com.lhb.friday.dto;

import com.lhb.friday.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysRoleDTO extends SysRole implements Serializable {

    private static final long serialVersionUID = 6811377784160054414L;

    private List<Long> permissionIds;

}
