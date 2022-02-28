package com.ssm.service;

import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/17 14:38
 */
public interface UserService extends UserDetailsService {
    public List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findUserByIdAndAllRole(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
