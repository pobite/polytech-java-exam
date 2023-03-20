package com.pobitecoding.roadroadpark.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.pobitecoding.findroad.Tree;
import com.pobitecoding.findroadpark.Type;
import com.pobitecoding.roadroadpark.obj.ConstructionImpl;
import com.pobitecoding.roadroadpark.obj.TreeImpl;
import com.pobitecoding.roadroadpark.util.ParkUtil;

public class Park {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        Map<Type, List> parkMap = new HashMap<>();
        ConstructionImpl conService = new ConstructionImpl();
        TreeImpl treeService = new TreeImpl();

        ConstructionImpl con = new ConstructionImpl();
        
        
        ParkUtil.input(con, scan);        
        ParkUtil.setR(con);
        
        
        parkMap.put(Type.Construction, conService);
        
        park.getMap().put(Type.Construction , park.getConstructions().add(con));

        // 나무 그늘의 수
        park.setTreeNum(park.scan.nextInt());
        
        for (int i = 0; i < park.getTreeNum(); i++) {
            TreeImpl tree = new TreeImpl();
            ParkUtil.input(tree);
            
            tree.setDistnace(park.distance(tree, con));
            park.getTrees().add(tree);
        }
        
        // 나무 출력
        for (Tree tr : park.trees) {
            System.out.println(tr.sound(con));
        }
    }
}