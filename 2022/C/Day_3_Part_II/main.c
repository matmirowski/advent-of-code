#include <stdio.h>
#include <string.h>

const int DATA_LENGTH = 300;

char findCommonChar(char* line1, char* line2, char* line3) {
    for (int j = 0; j < strlen(line1); j++) {
        char c1 = line1[j];
        for (int k = 0; k < strlen(line2); k++) {
            char c2 = line2[k];
            for (int l = 0; l < strlen(line3); l++) {
                char c3 = line3[l];
                if (c1 == c2 && c2 == c3) {
                    return c1;
                }
            }
        }
    }
    return '/';
}

int main() {
    char line[100];
    char lines[DATA_LENGTH][100]; // array of strings (300 - num of strings, 100 - max size)
    int prioritySum = 0;
    int lineCounter = 0;

    FILE *file = fopen("input.txt", "r");

    if (!file) {
        printf("File not found!");
        return 1;
    }

    // save all data to lines array
    while (fgets(line, sizeof(line), file)) {
        strcpy(lines[lineCounter], line);
        lineCounter++;
    }
    fclose(file);

    // find commonchar and calculate priority
    for (int i = 2; i < DATA_LENGTH; i = i + 3) {
        char commonChar = findCommonChar(lines[i], lines[i-1], lines[i-2]);
        int priority;
        if (commonChar >= 97)
            priority = commonChar - 96;
        else
            priority = commonChar - 38;
        prioritySum += priority;
    }

    printf("%d", prioritySum);
    return 0;
}
