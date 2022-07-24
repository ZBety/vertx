package com.example.entity;

import java.util.Date;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 20:49
 * @PackageName:com.example.entity
 * @ClassName: WholemealBread
 * @Description: 全麦面包实体类
 * @Version 1.0
 */
public class WholemealBread extends Bread{
  String name;
  double price;
  //state 状态分为三类 0 表示未过期， 1 表示过期日， 2 表示已过期
  int state;
  //保质期
  int QGP;
  Date createDate;

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

  public void setState(int state) {
    this.state = state;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  double getPrice() {
    return 0;
  }
}
