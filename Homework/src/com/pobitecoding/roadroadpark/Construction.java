package com.pobitecoding.roadroadpark;

import java.util.Objects;

public class Construction implements Thing {
    
    private int r;
    private Position position;
    

    public int getR() {
        return r;
    }

    public Position getPosition() {
        return position;
    }
    
    public void setR(int r) {
        this.r = r;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, r);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Construction other = (Construction) obj;
        return Objects.equals(position, other.position) && r == other.r;
    }

    @Override
    public String toString() {
        return "Construction [r=" + r + ", position=" + position + "]";
    }

    
}