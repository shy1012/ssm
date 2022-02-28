package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.controller
 * @date 2021/12/15 21:04
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView mv=new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
            @RequestMapping("/findAll.do")
            //@Secured("ROLE_ADMIN")
            public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size){
                ModelAndView mv=new ModelAndView();
                List<Orders> ordersList = ordersService.findAll(page,size);
                PageInfo pageInfo=new PageInfo(ordersList);
                mv.addObject("pageInfo",pageInfo);
                mv.setViewName("orders-list");
                return mv;
            }
            @RequestMapping("/findById.do")
            public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId) throws Exception {
                ModelAndView mv =new ModelAndView();
                Orders orders= ordersService.findById(ordersId);
                mv.addObject("orders",orders);
                mv.setViewName("orders-show");
                return mv;
            }
}
