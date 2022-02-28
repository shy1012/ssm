package com.ssm.dao;

import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.dao
 * @date 2021/12/17 14:59
 */
public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(property = "username",column ="username"),
            @Result(property = "email",column ="email"),
            @Result(property = "password",column ="password"),
            @Result(property = "phoneNum",column ="phoneNum"),
            @Result(property = "status",column ="status"),
            @Result(property = "roles",column ="id",javaType = java.util.List.class,many=@Many(select = "com.ssm.dao.RoleDao.findRoleByUserid"))
        })
   public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(property = "username",column ="username"),
            @Result(property = "email",column ="email"),
            @Result(property = "password",column ="password"),
            @Result(property = "phoneNum",column ="phoneNum"),
            @Result(property = "status",column ="status"),
            @Result(property = "roles",column ="id",javaType = java.util.List.class,many=@Many(select = "com.ssm.dao.RoleDao.findRoleByUserid"))
    })
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findUserByIdAndAllRole(String userId);

    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
