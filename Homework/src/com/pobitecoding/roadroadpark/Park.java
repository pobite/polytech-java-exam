package com.pobitecoding.roadroadpark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Park {
    
    private int treeNum;
    private Scanner scan;
    private Map<Type, List> map;
    private List<Tree> trees;
    private List<Construction> constructions;
    
    public Park() {
        scan = new Scanner(System.in);
        map = new HashMap<>();
        trees = new ArrayList<>();
        constructions = new ArrayList<>();
    }
    
    public int getTreeNum() {
        return treeNum;
    }

    public Scanner getScan() {
        return scan;
    }

    public Map<Type, List> getMap() {
        return map;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public List<Construction> getConstructions() {
        return constructions;
    }

    public void setTreeNum(int treeNum) {
        this.treeNum = treeNum;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public void setMap(Map<Type, List> map) {
        this.map = map;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void setConstructions(List<Construction> constructions) {
        this.constructions = constructions;
    }

    public void input(Thing thing) {
        int x = scan.nextInt(); // x 좌표
        int y = scan.nextInt(); // y 좌표
        
        if (thing instanceof Tree) {
            Tree tree = (Tree) thing;
            tree.getPosition().setXY(x, y);
        }
        if (thing instanceof Construction) {
            Tree tree = (Tree) thing;
            tree.getPosition().setXY(x, y);
        }
    }
    
    public double distance(Position pos1, Position pos2) {
        return Math.sqrt((pos1.getX() - pos2.getX()) * (pos1.getX() - pos2.getX()) 
                + (pos1.getY() - pos2.getY()) * (pos1.getY() - pos2.getY()));
    }
    
    public static void main(String[] args) {
        
        // Park 객체 생성
        Park park = new Park();
        
        // 공사장 객체 생성
        Construction con = new Construction();
        park.input(con);        
        con.setR(park.scan.nextInt()); // 공사 현장의 소음 크기
        
        
        // 에러~~~~~~~~~~~~~~
        park.getConstructions().add(con);
        System.out.println(park.getConstructions());
        
//        park.getMap().put(Type.Construction , park.getConstructions().add(con));

        // 나무 그늘의 수
        park.setTreeNum(park.scan.nextInt());
        
        for (int i = 0; i < park.getTreeNum(); i++) {
            Tree tree = new Tree();
            park.input(tree);
            
            //tree.setDistnace(park.distance(tree, con));
            park.getTrees().add(tree);
        }
        
//        for (Tree tr : park.trees) {
//            System.out.println(tr.sound(con));
//        }
    }
}