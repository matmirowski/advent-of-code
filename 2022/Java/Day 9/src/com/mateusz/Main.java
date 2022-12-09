package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static int START_X = 1000;
    public static int START_Y = 1000;
    public static int MAX_SIZE = 2000;

    public static int headPosX = START_X;
    public static int headPosY = START_Y;
    public static int tailPosX = START_X;
    public static int tailPosY = START_Y;

    public static void moveUp() {
        headPosY++;
        if (headPosY == tailPosY + 2) {
            if (headPosX == tailPosX + 1)
                tailPosX++;
            else if (headPosX == tailPosX - 1)
                tailPosX--;
            tailPosY++;
        }
    }

    public static void moveDown() {
        headPosY--;
        if (headPosY == tailPosY - 2) {
            if (headPosX == tailPosX + 1)
                tailPosX++;
            else if (headPosX == tailPosX - 1)
                tailPosX--;
            tailPosY--;
        }
    }

    public static void moveLeft() {
        headPosX--;
        if (headPosX == tailPosX - 2) {
            if (headPosY == tailPosY + 1)
                tailPosY++;
            else if (headPosY == tailPosY - 1)
                tailPosY--;
            tailPosX--;
        }
    }

    public static void moveRight() {
        headPosX++;
        if (headPosX == tailPosX + 2) {
            if (headPosY == tailPosY + 1)
                tailPosY++;
            else if (headPosY == tailPosY - 1)
                tailPosY--;
            tailPosX++;
        }
    }

    public static void move(char dir) {
        switch (dir) {
            case 'U' -> moveUp();
            case 'D' -> moveDown();
            case 'L' -> moveLeft();
            case 'R' -> moveRight();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int[][] visitedFields = new int[MAX_SIZE][MAX_SIZE];
        visitedFields[START_X][START_Y] = 1;

        while ((line = reader.readLine()) != null) {
            char dir = line.charAt(0);
            int spaceIndex = line.indexOf(' ');
            int move = Integer.parseInt(line.substring(spaceIndex + 1));
            for (int i = 0; i < move; i++) {
                move(dir);
                visitedFields[tailPosX][tailPosY] = 1;
            }
        }

        // summing visited fields
        int visited_sum = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (visitedFields[i][j] == 1)
                    visited_sum++;
            }
        }
        System.out.println(visited_sum);
    }
}
