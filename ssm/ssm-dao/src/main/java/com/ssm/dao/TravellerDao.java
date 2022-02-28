package com.ssm.dao;

import com.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.dao
 * @date 2021/12/17 11:06
 */
public interface TravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrdersId(String orderId) throws Exception;
}
