package com.pobitecoding.roadroadpark.util;

import java.util.Scanner;
import com.pobitecoding.roadroadpark.Position;
import com.pobitecoding.roadroadpark.obj.ConstructionImpl;
import com.pobitecoding.roadroadpark.obj.RoadObject;
import com.pobitecoding.roadroadpark.obj.TreeImpl;

public abstract class ParkUtil {
        
    public static void input(RoadObject thing, Scanner scan) {
        
        int x = scan.nextInt(); // x 좌표
        int y = scan.nextInt(); // y 좌표
        
        if (thing instanceof TreeImpl) {
            TreeImpl tree = (TreeImpl) thing;
            tree.getPosition().setXY(x, y);
        }
        if (thing instanceof ConstructionImpl) {
            TreeImpl tree = (TreeImpl) thing;
            tree.getPosition().setXY(x, y);
        }
    }
    
    public static double distance(Position pos1, Position pos2) {
        return Math.sqrt((pos1.getX() - pos2.getX()) * (pos1.getX() - pos2.getX()) 
                + (pos1.getY() - pos2.getY()) * (pos1.getY() - pos2.getY()));
    }
    
    public static void setR (RoadObject obj, Scanner scan) {
        if (obj instanceof ConstructionImpl) {
            ((ConstructionImpl) obj).setR(scan.nextInt());
        }
    }
    
    public static void getTreeNum (treeNum) {
        
    }
    
    
//    public static String sound(Construction con) {
//        if (this.getDistnace() < con.getR()) {
//            return "noisy";
//        } else {
//            return "silent";
//        }
//    }
    
}