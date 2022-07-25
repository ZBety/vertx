package com.example.entity;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 23:02
 * @PackageName:com.example.entity
 * @ClassName: CoarseCerealsBreadTest
 * @Description: 对杂粮面包实体类方法进行测试
 * @Version 1.0
 */
class CoarseCerealsBreadTest {

  /**
   * 对更新面包状态的实现逻辑进行更新
   * 这里需要注意，不能在0:00 - 2:00进行测试，
   * 因为测试用例在生成时间上往前多移动了2小时(想要得到还有两个小时过期的一个时间)，
   * 这样会导致无法覆盖所有的执行逻辑
   */
  @Test
  void setState(){
    //已过期的面包不需要获得价格 被销毁
    //得到了一个未过期的面包
    CoarseCerealsBread breadA = new CoarseCerealsBread();
    //这将是是一个当天过期的面包
    CoarseCerealsBread breadB = new CoarseCerealsBread();
    //这里借助Calendar类来得到前三天的日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(breadB.getCreateDate());
    calendar.add(calendar.DATE,-3);
    calendar.add(calendar.HOUR,2);

    breadB.setCreateDate(calendar.getTime());

    //这将得到一个已过期的面包
    CoarseCerealsBread breadC = new CoarseCerealsBread();
    calendar.setTime(breadC.getCreateDate());
    calendar.add(calendar.DATE,-3);
    breadC.setCreateDate(calendar.getTime());

    //计算实际价格前更新面包状态
    breadA.setState();
    breadB.setState();
    breadC.setState();

    System.out.println("面包A的状态为: "+breadA.getState());
    System.out.println("面包B的状态为: "+breadB.getState());
    System.out.println("面包C的状态为: "+breadC.getState());
  }

  /**
   * 对获取实际金额的实现逻辑进行测试
   */
  @Test
  void getPrice() throws Exception {
    //已过期的面包不需要获得价格 被销毁
    //得到了一个未过期的面包
    CoarseCerealsBread breadA = new CoarseCerealsBread();
    //这将是是一个当天过期的面包
    CoarseCerealsBread breadB = new CoarseCerealsBread();
    //这里借助Calendar类来得到前三天的日期
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(breadB.getCreateDate());
    calendar.add(calendar.DATE,-3);
    calendar.add(calendar.HOUR,2);

    breadB.setCreateDate(calendar.getTime());

    //计算实际价格前更新面包状态
    breadA.setState();
    breadB.setState();
    System.out.println("面包A的实际价格为: "+breadA.getPrice()+" 状态为:"+breadA.getState());
    System.out.println("面包B的实际价格为: "+breadB.getPrice()+" 状态为:"+breadB.getState());
  }
}
