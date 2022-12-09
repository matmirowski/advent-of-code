package com.mateusz;

public class Snake {
    private int x;
    private int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(char dir) {
        switch (dir) {
            case 'U' -> y++;
            case 'D' -> y--;
            case 'L' -> x--;
            case 'R' -> x++;
        }
    }
}
