package com.pobitecoding.project.vo;

import java.util.Date;

public class BookBorrow {
    
    private boolean isPossibleBorrow;
    private boolean isPossibleExtend;
    private String startDate;
    private String endDate;
    
    public BookBorrow() {
        isPossibleBorrow = true;
        isPossibleExtend = true;
        startDate = null;
        endDate = null;
    }

    public boolean isPossibleBorrow() {
        return isPossibleBorrow;
    }

    public void setPossibleBorrow(boolean isPossibleBorrow) {
        this.isPossibleBorrow = isPossibleBorrow;
    }

    public boolean isPossibleExtend() {
        return isPossibleExtend;
    }

    public void setPossibleExtend(boolean isPossibleExtend) {
        this.isPossibleExtend = isPossibleExtend;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
}