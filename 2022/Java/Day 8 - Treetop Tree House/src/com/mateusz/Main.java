package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static int[][] data = new int[99][99];

    public static boolean isTreeVisibleUp(int tree, int x, int y) {
        if (x == 0)
            return true;
        x--;
        while (x >= 0) {
            if (data[x][y] >= tree)
                return false;
            x--;
        }
        return true;
    }

    public static boolean isTreeVisibleDown(int tree, int x, int y) {
        if (x == 98)
            return true;
        x++;
        while (x <= 98) {
            if (data[x][y] >= tree)
                return false;
            x++;
        }
        return true;
    }

    public static boolean isTreeVisibleLeft(int tree, int x, int y) {
        if (y == 0)
            return true;
        y--;
        while (y >= 0) {
            if (data[x][y] >= tree)
                return false;
            y--;
        }
        return true;
    }

    public static boolean isTreeVisibleRight(int tree, int x, int y) {
        if (y == 98)
            return true;
        y++;
        while (y <= 98) {
            if (data[x][y] >= tree)
                return false;
            y++;
        }
        return true;
    }

    public static boolean isTreeVisible(int tree, int x, int y) {
        if (isTreeVisibleUp(tree, x, y) || isTreeVisibleDown(tree, x, y) || isTreeVisibleLeft(tree, x, y)
                || isTreeVisibleRight(tree, x, y))
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        int visibleTrees = 0;
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
                if (isTreeVisible(tree, row, col))
                    visibleTrees++;
            }
        }
        System.out.println(visibleTrees);
    }
}
