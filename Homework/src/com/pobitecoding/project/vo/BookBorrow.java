package com.pobitecoding.project.vo;

import java.util.Date;

public class BookBorrow {
    
    private boolean isPossibleBorrow;
    private boolean isPossibleExtend;
    private Date startDate;
    private Date endDate;
    
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}