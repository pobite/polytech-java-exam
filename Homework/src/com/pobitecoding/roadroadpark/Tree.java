package com.pobitecoding.roadroadpark;

import java.util.Objects;

public class Tree implements Thing {
    
    private Position position;
    
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tree other = (Tree) obj;
        return Objects.equals(position, other.position);
    }

    @Override
    public String toString() {
        return "Tree [position=" + position + "]";
    }
    
//    public String sound(Construction con) {
////        if (this.getDistnace() < con.getR()) {
////            return "noisy";
////        } else {
////            return "silent";
////        }
//    }
}