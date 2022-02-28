package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service.impl
 * @date 2021/12/18 17:13
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role)  throws Exception{
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRole(String roleId) {
            roleDao.deleteUserRole(roleId);
            roleDao.deletePromissionRole(roleId);
            roleDao.deleteRole(roleId);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) {
        return roleDao.findRoleByIdAndAllPermission(roleId);
    }

    @Override
    public void addPremissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPremissionToRole(roleId,permissionId);
        }
    }


}
