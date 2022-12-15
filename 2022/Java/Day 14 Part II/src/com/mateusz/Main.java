package com.mateusz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static char[][] map = new char[1000][1000];

    public static void initFillMap() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                map[i][j] = '.';
            }
        }
    }

    public static void generateFloor(int y) {
        for (int x = 0; x < 1000; x++) {
            map[x][y] = '#';
        }
    }

    public static void main(String[] args) throws IOException {
        initFillMap();
        BufferedReader reader = new BufferedReader(new FileReader("src/com/mateusz/input.txt"));
        String line;

        int highestPoint = 0;

        while ((line = reader.readLine()) != null) {
            String[] coords = line.split("->");
            for (int i = 0; i < coords.length - 1; i++) {
                String[] coordsInnerFirst = coords[i].split(",");
                int xFirst = Integer.parseInt(coordsInnerFirst[0].trim());
                int yFirst = Integer.parseInt(coordsInnerFirst[1].trim());
                String[] coordsInnerSecond = coords[i + 1].split(",");
                int xSecond = Integer.parseInt(coordsInnerSecond[0].trim());
                int ySecond = Integer.parseInt(coordsInnerSecond[1].trim());
                if (xFirst == xSecond) { // x = x
                    if (yFirst > ySecond) {
                        int temp = ySecond;
                        ySecond = yFirst;
                        yFirst = temp;
                    }
                    for (int j = yFirst; j <= ySecond; j++) {
                        map[xFirst][j] = '#';
                        if (yFirst > highestPoint) {
                            highestPoint = yFirst;
                        }
                    }
                } else { // y = y
                    if (xFirst > xSecond) {
                        int temp = xSecond;
                        xSecond = xFirst;
                        xFirst = temp;
                    }
                    for (int j = xFirst; j <= xSecond; j++) {
                        map[j][yFirst] = '#';
                        if (yFirst > highestPoint) {
                            highestPoint = yFirst;
                        }
                    }
                }
            }
        }

        // generate floor
        generateFloor(highestPoint + 2);

        // generate sand (falling down from (500,0)
        int sand = 0;

        while(true) {
            int currentX = 500;
            int currentY = 0;
            sand++;
            while(true) {
                if (map[currentX][currentY + 1] == '.') {
                    currentY++;
                    continue;
                }
                if (map[currentX][currentY + 1] != '.') { // barrier underneath
                    if (map[currentX - 1][currentY + 1] == '.') { // diagonally to the left
                        currentX--;
                        currentY++;
                    }
                    else if (map[currentX + 1][currentY + 1] == '.') { // diagonally to the right
                        currentX++;
                        currentY++;
                    }
                    else { // everything is blocked
                        map[currentX][currentY] = 'O';
                        if (currentX == 500 && currentY == 0) {
                            System.out.println(sand);
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }
}
