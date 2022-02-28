package com.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 琴宝宝
 * @version V1.0
 * @Package com.ssm.utils
 * @date 2021/12/14 17:33
 */
public class DateUtils {
    //日期转字符串
    public static String DataToString(Date date,String parrent){
        SimpleDateFormat sdf=new SimpleDateFormat(parrent);
        String format = sdf.format(date);
        return format;
    }
    //字符串转日期
    public static Date StringToDate(String format,String parrent) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(parrent);
        Date date = sdf.parse(format);
        return date;
    }
}
