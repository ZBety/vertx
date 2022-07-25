package com.example.entity;

import java.io.IOError;
import java.io.IOException;
import java.util.Date;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 20:51
 * @PackageName:com.example.entity
 * @ClassName: CoarseCerealsBread
 * @Description: 杂粮面包实体类
 * @Version 1.0
 */
public class CoarseCerealsBread extends Bread{
  String name;
  double price;
  //state 状态分为三类 0 表示未过期， 1 表示过期日， 2 表示已过期
  int state;
  //保质期
  int QGP;
  Date createDate;

  public CoarseCerealsBread() {
    this.name = "杂粮面包";
    this.price = 10.0;
    this.state = 0;
    this.QGP = 3;
    this.createDate = new Date();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getState() {
    return state;
  }

  public void setState() {
    //用时间戳来计算是否过期
    //当前时间-生产时间-保质期>=0 表示过期了
    System.out.println(new Date().getDay() + " " + this.createDate.getDay());
    if (new Date().getTime() - this.createDate.getTime() - 24*60*60*1000*this.QGP>=0)
      this.state = 2;
    //判断是否今天过期
    else if (new Date().getDay() - this.createDate.getDay() == this.QGP){
      this.state = 1;
    }else {
      this.state = 0;
    }
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 杂粮面包，在过期当天的早上07:00-09:00免费领取
   * 理解为过期当天07:00-09:00免费，过了这个时间段变为原价 过了今天才销毁
   * 最终返回该面包实际需要支付的金额
   * @return double
   */
  @Override
  double getPrice() throws Exception {
    if (this.state==2)
      throw new Exception("状态异常！");
    //state == 1  表示过期当天
    if (this.state==1){
      // 时间上属于过期当天的7:00-9:00
      if ( (createDate.getHours()>6 && createDate.getHours()<9) || createDate.getHours()==9 && createDate.getMinutes()==0)
        return 0.0;
    }
    return this.price;
  }
}
