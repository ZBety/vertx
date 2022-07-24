package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 20:56
 * @PackageName:com.example.entity
 * @ClassName: Order
 * @Description: 订单实体类
 * @Version 1.0
 */
public class Order {
  String id;
  Date createDate;
  List<Bread> commodity;
  double money;

  public Order() {
    this.id = UUID.randomUUID().toString().replace("-","");
    this.createDate = new Date();
    this.commodity = new ArrayList<>();
    this.money = 0;
  }

  public List<Bread> getCommodity() {
    return commodity;
  }

  public void addCommodity(Bread bread) {
    commodity.add(bread);
    this.setMoney(this.money+bread.getPrice());
    this.commodity = commodity;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }
}
