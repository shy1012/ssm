package com.ssm.service;

import com.ssm.domain.SysLog;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.service
 * @date 2021/12/19 22:01
 */
public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
