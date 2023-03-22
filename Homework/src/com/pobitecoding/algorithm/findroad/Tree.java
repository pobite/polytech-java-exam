package com.pobitecoding.algorithm.findroad;

import java.util.Objects;

public class Tree extends Position {
    
    private double distnace;

    public Tree() {
        super();
    }
    
    public Tree(int x, int y) {
        super(x, y);
    }
    
    public Tree(int x, int y, double position) {
        super(x, y);
        this.distnace = position;
    }

    public double getDistnace() {
        return distnace;
    }

    public void setDistnace(double distnace) {
        this.distnace = distnace;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(distnace);
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
        Tree other = (Tree) obj;
        return Double.doubleToLongBits(distnace) == Double.doubleToLongBits(other.distnace);
    }

    public String toString(Construction con) {
        
        if (this.getDistnace() < con.getR()) {
            return "noisy";
        } else {
            return "silent";
        }
    }
}
