#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int checkCycle(int cycle, int x) {
    if ((cycle + 20) % 40 == 0) {
        return cycle * x;
    }
    return 0;
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
            signalSum += checkCycle(cycle, x);
        } else { // noop
            value = 0;
        }
        cycle++;
        signalSum += checkCycle(cycle, x);
        x += value;
    }
    printf("%d", signalSum);
    return 0;
}
