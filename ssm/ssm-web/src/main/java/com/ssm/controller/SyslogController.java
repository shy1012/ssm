package com.ssm.controller;

import com.ssm.domain.Role;
import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.controller
 * @date 2021/12/19 22:40
 */
@Controller
@RequestMapping("/sysLog")
public class SyslogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<SysLog> sysLogs= sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
