package com.ssm.service;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/18 17:12
 */
public interface RoleService {
    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id);


    void deleteRole(String roleId);

    List<Permission> findRoleByIdAndAllPermission(String roleId);

    void addPremissionToRole(String roleId, String[] permissionIds);
}
