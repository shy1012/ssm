package com.ssm.dao;

import com.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.dao
 * @date 2021/12/18 16:26
 */
public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findByRoleId(String roleId)throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id=#{id}")
    Permission findById(String id);

    @Delete("delete from permission where id=#{id}")
    void delectPermission(String id);

    @Delete("delete from role_permission where permissionId=#{id}")
    void delectRolePermission(String id);
}
