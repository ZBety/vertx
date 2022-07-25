package com.example.entity;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Z/Bety
 * @Date 2022/7/25 8:51
 * @PackageName:com.example.entity
 * @ClassName: WholemealBreadTest
 * @Description: 全麦面包需求逻辑单元测试
 * @Version 1.0
 */
class WholemealBreadTest {

  @Test
  void setState() {
    //已过期的面包不需要获得价格 被销毁
    //得到了一个未过期的面包
    WholemealBread breadA = new WholemealBread();
    //这将是是一个当天过期的面包
    WholemealBread breadB = new WholemealBread();
    //这里借助Calendar类来得到前一天的日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(breadB.getCreateDate());
    calendar.add(calendar.DATE,-2);
    calendar.add(calendar.HOUR,2);

    breadB.setCreateDate(calendar.getTime());

    //这将得到一个已过期的面包
    WholemealBread breadC = new WholemealBread();
    calendar.setTime(breadC.getCreateDate());
    calendar.add(calendar.DATE,-2);
    breadC.setCreateDate(calendar.getTime());

    //计算实际价格前更新面包状态
    breadA.setState();
    breadB.setState();
    breadC.setState();

    System.out.println("面包A的状态为: "+breadA.getState());
    System.out.println("面包B的状态为: "+breadB.getState());
    System.out.println("面包C的状态为: "+breadC.getState());
  }

  @Test
  void getPrice() throws Exception {
    //已过期的面包不需要获得价格 被销毁
    //得到了一个未过期的面包
    WholemealBread breadA = new WholemealBread();
    //这将是是一个当天过期的面包
    WholemealBread breadB = new WholemealBread();
    //这里借助Calendar类来得到前三天的日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(breadB.getCreateDate());
    calendar.add(calendar.DATE,-2);
    calendar.add(calendar.HOUR,2);

    breadB.setCreateDate(calendar.getTime());

    //计算实际价格前更新面包状态
    breadA.setState();
    breadB.setState();
    System.out.println("面包A的实际价格为: "+breadA.getPrice()+" 状态为:"+breadA.getState());
    System.out.println("面包B的实际价格为: "+breadB.getPrice()+" 状态为:"+breadB.getState());
  }
}
