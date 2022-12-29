#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

int calculateDistance(int x1, int y1, int x2, int y2) {
    return abs(x1 - x2) + abs(y1 - y2);
}

int isFieldBlocked(int fieldX, int fieldY, int sensorX, int sensorY, int distanceToBeacon) {
    if (calculateDistance(fieldX, fieldY, sensorX, sensorY) <= distanceToBeacon) {
        return 1;
    }
    return 0;
}

int main() {
    char line[85];
    int sensorsX[38] = {0};
    int sensorsY[38] = {0};
    int beaconsX[38] = {0};
    int beaconsY[38] = {0};
    int distanceToBeacon[38] = {0};

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    int counter = 0;
    while (fgets(line, sizeof(line), file)) {
        char data[10][20];
        char* splitLine;
        splitLine = strtok(line, " ");
        for (int i = 0; splitLine != NULL; i++) {
            strcpy(data[i], splitLine);
            splitLine = strtok(NULL, " ");
        }
        int sensorXCommaIndex = indexOf(data[2], ',');
        int sensorYCommaIndex = indexOf(data[3], ':');
        int beaconXCommaIndex = indexOf(data[8], ',');

        char sensorXStr[12];
        substring(2, sensorXCommaIndex, data[2], sensorXStr);
        char sensorYStr[12];
        substring(2, sensorYCommaIndex, data[3], sensorYStr);
        char beaconXStr[12];
        substring(2, beaconXCommaIndex, data[8], beaconXStr);
        char beaconYStr[12];
        substring(2, strlen(data[9]), data[9], beaconYStr);

        sensorsX[counter] = atoi(sensorXStr);
        sensorsY[counter] = atoi(sensorYStr);
        beaconsX[counter] = atoi(beaconXStr);
        beaconsY[counter] = atoi(beaconYStr);
        distanceToBeacon[counter] = calculateDistance(sensorsX[counter], sensorsY[counter],
                                                      beaconsX[counter], beaconsY[counter]);
        counter++;
    }

    int blockedFields = 0;
    int constY = 2000000;

    for (int x = -1000000; x < 5000000; x++) {
        for (int i = 0; i < 38; i++) {
            if (beaconsX[i] == x && beaconsY[i] == constY) {
                break;
            }
            if (isFieldBlocked(x, constY, sensorsX[i], sensorsY[i],
                               distanceToBeacon[i])) {
                blockedFields++;
                break;
            }
        }
    }
    printf("%d", blockedFields);

    return 0;
}
