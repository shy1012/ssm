package com.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.utils
 * @date 2021/12/18 15:38
 */
public class BCryptPasswordEncoderUtils {
    public static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodeerString(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String s = encodeerString(password);
        System.out.println(s);
    }

}
