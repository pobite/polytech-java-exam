package com.pobitecoding.algorithm.findroad;

import java.util.Objects;

public class Construction extends Position {
    
    private int r;
    
    public Construction() {
        super();
    }
    
    public Construction(int x, int y) {
        super(x, y);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(r);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Construction other = (Construction) obj;
        return r == other.r;
    }

    @Override
    public String toString() {
        return "Construction [r=" + r + "]";
    }

}