#include <stdio.h>
#include <string.h>
#include <stdlib.h>

const int START_X = 300;
const int START_Y = 300;
const int MAX_SIZE = 600;

int headPosX = START_X;
int headPosY = START_Y;
int tailPosX = START_X;
int tailPosY = START_Y;

void moveUp() {
    headPosY++;
    if (headPosY == tailPosY + 2) {
        if (headPosX == tailPosX + 1)
            tailPosX++;
        else if (headPosX == tailPosX - 1)
            tailPosX--;
        tailPosY++;
    }
}

void moveDown() {
    headPosY--;
    if (headPosY == tailPosY - 2) {
        if (headPosX == tailPosX + 1)
            tailPosX++;
        else if (headPosX == tailPosX - 1)
            tailPosX--;
        tailPosY--;
    }
}

void moveLeft() {
    headPosX--;
    if (headPosX == tailPosX - 2) {
        if (headPosY == tailPosY + 1)
            tailPosY++;
        else if (headPosY == tailPosY - 1)
            tailPosY--;
        tailPosX--;
    }
}

void moveRight() {
    headPosX++;
    if (headPosX == tailPosX + 2) {
        if (headPosY == tailPosY + 1)
            tailPosY++;
        else if (headPosY == tailPosY - 1)
            tailPosY--;
        tailPosX++;
    }
}

void move(char dir) {
    switch (dir) {
        case 'U':
            moveUp();
            break;
        case 'D':
            moveDown();
            break;
        case 'L':
            moveLeft();
            break;
        case 'R':
            moveRight();
            break;
    }
}

// own implementation of indexOf
int indexOf(char line[], char c) {
    for (int i = 0; i < strlen(line); i++) {
        if (line[i] == c)
            return i;
    }
    return -1;
}

// own implementation of substring
void substring(int start, int end, char* src, char* dest) {
    for (int i = start, destIndex = 0; i < end; i++, destIndex++) {
        *(dest + destIndex) = *(src + i);
        *(dest + destIndex + 1) = '\0';
    }
}

int main() {
    char line[100];
    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    int visitedFields[MAX_SIZE][MAX_SIZE];
    for (int i = 0; i < MAX_SIZE; i++) {
        for (int j = 0; j < MAX_SIZE; j++) {
            visitedFields[i][j] = 0;
        }
    }
    visitedFields[START_X][START_Y] = 1;
    while (fgets(line, sizeof(line), file)) {
        char dir = line[0];
        int spaceIndex = indexOf(line, ' ');
        char moveStr[10];
        substring(spaceIndex + 1, strlen(line), line, moveStr);
        int moveNumber = atoi(moveStr);
        for (int i = 0; i < moveNumber; i++) {
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
    printf("%d", visited_sum);
    return 0;
}
