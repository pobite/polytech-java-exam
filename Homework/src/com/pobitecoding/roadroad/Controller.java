package com.pobitecoding.roadroad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    
    private int treeNum;
    private Scanner scan;
    private List<Tree> trees;
    
    public Controller() {
        scan = new Scanner(System.in);
        trees = new ArrayList<>();
    }

    public int getTreeNum() {
        return treeNum;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setTreeNum(int treeNum) {
        this.treeNum = treeNum;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void inputXY(Position pos) {
        int x = scan.nextInt(); // x 좌표
        int y = scan.nextInt(); // y 좌표
        pos.setXY(x, y);
    }
    
    public double distance(Position pos1, Position pos2) {
        return Math.sqrt((pos1.getX() - pos2.getX()) * (pos1.getX() - pos2.getX()) 
                + (pos1.getY() - pos2.getY()) * (pos1.getY() - pos2.getY()));
    }
    
    public static void main(String[] args) {
        
        // Controller 객체 생성
        Controller controller = new Controller();

        // 공사장 객체 생성
        Construction con = new Construction();
        controller.inputXY(con);
        
        con.setR(controller.scan.nextInt()); // 공사 현장의 소음 크기
        
        // 나무 그늘의 수
        controller.setTreeNum(controller.scan.nextInt());
        
        for (int i = 0; i < controller.getTreeNum(); i++) {
            Tree tree = new Tree();
            controller.inputXY(tree);
            tree.setDistnace(controller.distance(tree, con));
            controller.getTrees().add(tree);
        }
        
        for (Tree tr : controller.trees) {
            System.out.println(tr.toString(con));
        }
    }
}