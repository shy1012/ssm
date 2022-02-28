package com.ssm.service;

import com.ssm.domain.Orders;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/15 21:06
 */
public interface OrdersService {
    List<Orders> findAll(int page,int size);

    public Orders findById(String ordersId) throws Exception;
}
