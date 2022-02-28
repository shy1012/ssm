package com.ssm.service;

import com.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/14 15:10
 */
public interface ProductService {
    public List<Product> findAll(int page,int size);

    void save(Product product);
}
