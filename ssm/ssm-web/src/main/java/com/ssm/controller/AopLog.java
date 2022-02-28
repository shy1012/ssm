package com.ssm.controller;

import com.ssm.domain.SysLog;
import com.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.controller
 * @date 2021/12/19 20:41
 */
@Component
@Aspect
public class AopLog {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date stratTime;//首次访问时间
    private Class clazz;//访问的类
    private Method method;//访问的方法


    //前置通知
    @Before("execution(* com.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        stratTime = new Date();
        clazz = jp.getTarget().getClass();//访问的类
        String methodName = jp.getSignature().getName();//获取方法名字
        Object[] args = jp.getArgs();//获取方法参数
        //获取具体执行方法的method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);//只能获取无惨的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);
        }
    }

    //后置通知
    @After("execution(* com.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        Long time = new Date().getTime() - stratTime.getTime();

        String url = "";
        //获取Url
        if (clazz != null && method != null && clazz != AopLog.class) {
            //获取类上url
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null && (classAnnotation.value())[0]!="/sysLog") {
                String[] classValue = classAnnotation.value();

                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
                //获取IP
                String ip = request.getRemoteAddr();
                //获取操作用户
                SecurityContext context = SecurityContextHolder.getContext();
                User user = (User) context.getAuthentication().getPrincipal();
                String username = user.getUsername();
                //String username=request.getsession.getAttribute("spring_Security_context")
                SysLog sysLog=new SysLog();
                sysLog.setIp(ip);
                sysLog.setExecutionTime(time);
                sysLog.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                sysLog.setUrl(url);
                sysLog.setUsername(username);
                sysLog.setVisitTime(stratTime);

                sysLogService.save(sysLog);
            }


        }

    }

}