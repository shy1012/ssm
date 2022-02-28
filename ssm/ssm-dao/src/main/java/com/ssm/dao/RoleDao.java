package com.ssm.dao;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.dao
 * @date 2021/12/17 16:24
 */
public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userid})")
    @Results({
            @Result(id=true,column ="id",property = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.PermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserid(String useriId);

    @Select("select * from role")
    public List<Role> findAll() throws Exception;
    @Insert("insert into role (roleName, roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id=true,column ="id",property = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id);

    @Delete("delete from role where id=#{roleId}")
    void deleteRole(String roleId);

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteUserRole(String roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deletePromissionRole(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findRoleByIdAndAllPermission(String roleId);

    @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPremissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
