#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void displayCRT(int x, int cycle) {
    if (x == cycle-1 || x - 1 == cycle-1 || x + 1 == cycle-1)
        printf("#");
    else
        printf(".");
}

// my implementation of substring
void substring(int start, int end, char* src, char* dest) {
    for (int i = start, destIndex = 0; i < end; i++, destIndex++) {
        *(dest + destIndex) = *(src + i);
        *(dest + destIndex + 1) = '\0';
    }
}

int main() {
    char line[20];
    int value = 0, x = 1, cycle = 0, signalSum = 0;

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        if (strcmp(line, "noop\n") != 0) { // if line != noop
            char valueStr[20];
            substring(5, strlen(line), line, valueStr);
            value = atoi(valueStr);
            cycle++;
            displayCRT(x, cycle);
            if (cycle % 40 == 0) {
                printf("\n");
                cycle = 0;
            }
        } else { // noop
            value = 0;
        }
        cycle++;
        displayCRT(x, cycle);
        if (cycle % 40 == 0) {
            printf("\n");
            cycle = 0;
        }
        x += value;
    }
    return 0;
}
