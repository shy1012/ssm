package com.ssm.service.impl;

import com.ssm.dao.PermissionDao;
import com.ssm.domain.Permission;
import com.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service.impl
 * @date 2021/12/18 19:53
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void deletePermission(String id) throws Exception {
            permissionDao.delectRolePermission(id);
            permissionDao.delectPermission(id);
    }
}
