package com.pobitecoding.roadroadpark.copy;

import java.util.Objects;

public class Position {

    private int x;
    private int y;
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }
    
    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }
    
}
