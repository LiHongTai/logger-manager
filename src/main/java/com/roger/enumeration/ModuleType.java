package com.roger.enumeration;

public enum ModuleType {
    DEFAULT("1"),//默认模块
    ORDER("2"),//订单模块
    CART("3");//购物车

    private String module;

    private ModuleType(String module){
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public static void main(String[] args) {
        System.out.println(new Class[0]);
    }
}
