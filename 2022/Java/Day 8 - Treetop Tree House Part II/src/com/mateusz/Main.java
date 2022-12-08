package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static int[][] data = new int[99][99];

    public static int treesVisibleUp(int tree, int x, int y) {
        int treeCounter = 1;
        if (x == 0)
            return treeCounter;
        x--;
        while (x >= 0) {
            if (data[x][y] >= tree)
                return treeCounter;
            x--;
            treeCounter++;
        }
        return treeCounter - 1;
    }

    public static int treesVisibleDown(int tree, int x, int y) {
        int treeCounter = 1;
        if (x == 98)
            return treeCounter;
        x++;
        while (x <= 98) {
            if (data[x][y] >= tree)
                return treeCounter;
            x++;
            treeCounter++;
        }
        return treeCounter - 1;
    }

    public static int treesVisibleLeft(int tree, int x, int y) {
        int treeCounter = 1;
        if (y == 0)
            return treeCounter;
        y--;
        while (y >= 0) {
            if (data[x][y] >= tree)
                return treeCounter;
            y--;
            treeCounter++;
        }
        return treeCounter - 1;
    }

    public static int treesVisibleRight(int tree, int x, int y) {
        int treeCounter = 1;
        if (y == 98)
            return treeCounter;
        y++;
        while (y <= 98) {
            if (data[x][y] >= tree)
                return treeCounter;
            y++;
            treeCounter++;
        }
        return treeCounter - 1;
    }

    public static int getTreesScore(int tree, int x, int y) {
        return treesVisibleUp(tree, x, y) * treesVisibleDown(tree, x, y) * treesVisibleLeft(tree, x, y)
                * treesVisibleRight(tree, x, y);
    }

    public static void main(String[] args) throws IOException {
        int highestScore = 0;
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;
        int x = 0;
        while ((line = reader.readLine()) != null) {
            for (int y = 0; y < 99; y++) {
                data[x][y] = line.charAt(y) - '0';
            }
            x++;
        }
        for (int row = 0; row < 99; row++) {
            for (int col = 0; col < 99; col++) {
                int tree = data[row][col];
                int score = getTreesScore(tree, row, col);
                if (getTreesScore(tree, row, col) > highestScore)
                    highestScore = score;
            }
        }
        System.out.println(highestScore);
    }
}
