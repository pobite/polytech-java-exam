package com.pobitecoding.roadroadpark.obj;

import java.util.Objects;
import com.pobitecoding.roadroadpark.Position;

public class TreeImpl implements RoadObject {
    
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
        TreeImpl other = (TreeImpl) obj;
        return Objects.equals(position, other.position);
    }

    @Override
    public String toString() {
        return "Tree [position=" + position + "]";
    }
    

}