package com.example.starter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 21:40
 * @PackageName:com.example.starter
 * @ClassName: Client
 * @Description: 模拟客户端操作界面
 * @Version 1.0
 */
public class Client {
  public static void main(String[] args) {
    Date test = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(test);
    cal.add(cal.DATE,-1);
    long num = test.getTime()-cal.getTimeInMillis();
    System.out.println(num/24/60/60);
    System.out.println(test.getHours());
//    System.out.println();
  }
}
