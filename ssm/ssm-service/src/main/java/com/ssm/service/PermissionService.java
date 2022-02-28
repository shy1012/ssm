package com.ssm.service;

import com.ssm.domain.Permission;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/18 19:52
 */
public interface PermissionService {
    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id);

    void deletePermission(String id) throws Exception;
}
