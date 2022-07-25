package com.example.entity;

import java.util.Date;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 17:10
 * @PackageName:com.example.entity
 * @ClassName: Bread
 * @Description: 面包的实体类接口
 * @Version 1.0
 */
public abstract class Bread {
    abstract double getPrice() throws Exception;
  public int updateState(Date time,int QGP) {
    //用时间戳来计算是否过期
    //当前时间-生产时间-保质期>=0 表示过期了
    if (new Date().getTime() - time.getTime() - 24*60*60*1000*QGP>=0)
      return 2;
      //判断是否今天过期
    else if (new Date().getDate() - time.getDate() == QGP){
      return 1;
    }else {
      return 0;
    }
  }
}
