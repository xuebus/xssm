package com.xuebusi.xssm.pattern.observer.middle.impl;

import com.xuebusi.xssm.pattern.observer.middle.Observer;
import com.xuebusi.xssm.pattern.observer.middle.Subject;

public class StockObserver implements Observer {

    private String name;
    private Subject sub;

    public StockObserver(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }

    @Override
    public void update() {
        System.out.println(this.name + ":update====被监听者状态发生变化:" + sub.getAction());
    }
}
