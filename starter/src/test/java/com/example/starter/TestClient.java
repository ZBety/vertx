package com.example.starter;

import com.example.entity.*;
import jdk.nashorn.internal.objects.AccessorPropertyDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author Z/Bety
 * @Date 2022/7/25 9:12
 * @PackageName:com.example.starter
 * @ClassName: TestClient
 * @Description: 测试客户端
 * @Version 1.0
 */
public class TestClient {
  List<Bread> items = new ArrayList<>();

  @BeforeEach
  void init(){
    Random random = new Random();
    //初始化杂粮面包
    for (int i = 0 ; i<5;i++){
      CoarseCerealsBread item = new CoarseCerealsBread();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(item.getCreateDate());
      calendar.add(calendar.DATE,-random.nextInt(4));
      calendar.add(calendar.HOUR,random.nextInt(2));
      item.setCreateDate(calendar.getTime());
      items.add(item);
    }
    //初始化全麦面包
    for (int i = 0 ; i<5;i++){
      WholemealBread item = new WholemealBread();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(item.getCreateDate());
      calendar.add(calendar.DATE,-random.nextInt(3));
      calendar.add(calendar.HOUR,random.nextInt(2));
      item.setCreateDate(calendar.getTime());
      items.add(item);
    }
    //初始化金枪鱼三明治
    for (int i = 0 ; i<5;i++){
      TunaSandwich item = new TunaSandwich();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(item.getCreateDate());
      calendar.add(calendar.DATE,-random.nextInt(2));
      calendar.add(calendar.HOUR,random.nextInt(2));
      item.setCreateDate(calendar.getTime());
      items.add(item);
    }
  }

  @Test
  void tt() throws Exception {
    Order order = new Order();
    System.out.println("编号       名称       单价      生产时间");
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i) instanceof CoarseCerealsBread){
        CoarseCerealsBread item = (CoarseCerealsBread) items.get(i);
        item.setState();
        if (item.getState()!=2){
          System.out.println(i+"       "+item.getName()+ "       10       " + item.getCreateDate());
          order.addCommodity(item);
        }
      }else if (items.get(i) instanceof WholemealBread){
        WholemealBread item = (WholemealBread) items.get(i);
        item.setState();
        if (item.getState()!=2){
          System.out.println(i+"       "+item.getName()+ "       12       " + item.getCreateDate());
          order.addCommodity(item);
        }
      }else {
        TunaSandwich item = (TunaSandwich) items.get(i);
        item.setState();
        if (item.getState()!=2){
          System.out.println(i+"       "+item.getName()+ "       12       " + item.getCreateDate());
          order.addCommodity(item);
        }
      }

    }

    System.out.println("总金额为："+order.getMoney());
  }


}
