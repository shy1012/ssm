package com.ssm.dao;

import com.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.dao
 * @date 2021/12/17 10:54
 */
public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
