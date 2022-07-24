package com.example.starter;

import io.vertx.core.Vertx;

/**
 * @Author Z/Bety
 * @Date 2022/7/24 14:11
 * @PackageName:com.example.starter
 * @ClassName: Main
 * @Description: TODO
 * @Version 1.0
 */
public class Main {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }
}
