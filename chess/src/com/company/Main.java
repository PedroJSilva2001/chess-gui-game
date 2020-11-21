package com.company;
import board.ChessBoard;
import pieces.*;
import java.util.*;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hi");
        ChessBoard b = new ChessBoard();
        Bishop bishop = new Bishop(0, 0, "white");
        change(bishop);
        System.out.println(bishop.getX());
        System.out.println(bishop.getY());
        Vector<Bishop> v = new Vector<Bishop>();
        changeV(v);
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.elementAt(i).getX());
            System.out.println(v.elementAt(i).getY());
        }

    }

    public static void change(Bishop bishop) {
        bishop.setPosition(1,1);
    }
    public static void changeV(Vector<Bishop>v) {
        Bishop bishop = new Bishop(0, 0, "white");
        v.add(bishop);
    }
}
