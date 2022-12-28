#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define ROWS 1000
#define COLUMNS 1000

char map[ROWS][COLUMNS];

void initFillMap() {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLUMNS; j++) {
            map[i][j] = '.';
        }
    }
}

void substring(int start, int end, char* src, char* dest) {
    for (int i = start, destIndex = 0; i < end; i++, destIndex++) {
        *(dest + destIndex) = *(src + i);
        *(dest + destIndex + 1) = '\0';
    }
}

int indexOf(char line[], char c) {
    for (int i = 0; i < strlen(line); i++) {
        if (line[i] == c)
            return i;
    }
    return -1;
}

int main() {
    initFillMap();
    char line[300];

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }


    while (fgets(line, sizeof(line), file)) {
        char coords[50][12];
        int coordsSize = 0;
        char* splitLine;
        splitLine = strtok(line, " -> ");
        for (int i = 0; splitLine != NULL; i++) {
            strcpy(coords[i], splitLine);
            coordsSize++;
            splitLine = strtok(NULL, " -> ");
        }

        for (int i = 0; i < coordsSize - 1; i++) {
            // first
            int commaIndex = indexOf(coords[i], ',');
            char strX[5];
            char strY[5];
            substring(0, commaIndex, coords[i], strX);
            substring(commaIndex + 1, strlen(coords[i]), coords[i], strY);
            int xFirst = atoi(strX);
            int yFirst = atoi(strY);

            // second
            int commaIndex2 = indexOf(coords[i + 1], ',');
            char strX2[5];
            char strY2[5];
            substring(0, commaIndex2, coords[i + 1], strX2);
            substring(commaIndex2 + 1, strlen(coords[i + 1]), coords[i + 1], strY2);
            int xSecond = atoi(strX2);
            int ySecond = atoi(strY2);

            if (xFirst == xSecond) { // x = x
                if (yFirst > ySecond) {
                    int temp = ySecond;
                    ySecond = yFirst;
                    yFirst = temp;
                }
                for (int j = yFirst; j <= ySecond; j++) {
                    map[xFirst][j] = '#';
                }
            } else { // y = y
                if (xFirst > xSecond) {
                    int temp = xSecond;
                    xSecond = xFirst;
                    xFirst = temp;
                }
                for (int j = xFirst; j <= xSecond; j++) {
                    map[j][yFirst] = '#';
                }
            }
        }

    }

    int sand = 0;

    while(1) {
        int currentX = 500;
        int currentY = 0;
        sand++;
        while(1) {
            if (currentY == 999) {
                printf("%d", sand - 1);
                return 0;
            }
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
                    break;
                }
            }
        }
    }
}
