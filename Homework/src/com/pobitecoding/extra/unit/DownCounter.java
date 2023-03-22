package com.pobitecoding.extra.unit;

public class DownCounter implements Counter {
    
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int count() {
        count--;
        return getCount();
    }
}
