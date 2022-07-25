package com.example.entity;

import java.util.Date;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 20:53
 * @PackageName:com.example.entity
 * @ClassName: TunaSandwich
 * @Description: 金枪鱼三明治实体类
 * @Version 1.0
 */
public class TunaSandwich extends Bread{
  String name;
  double price;
  //state 状态分为三类 0 表示未过期， 1 表示过期日， 2 表示已过期
  int state;
  //保质期
  int QGP;
  Date createDate;

  public TunaSandwich() {
    this.name = "金枪鱼三明治";
    this.price = 12.00;
    this.state = 0;
    this.QGP = 1;
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
    this.state = updateState(this.createDate,this.QGP);
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  double getPrice() throws Exception {
    if (this.state==2)
      throw new Exception("状态异常！");
    //无论过期当天还是没过期都是原价
    return this.price;
  }
}
