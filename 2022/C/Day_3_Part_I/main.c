#include <stdio.h>
#include <string.h>

int main() {
    char line[100];
    int prioritySum = 0;

    FILE *file = fopen("input.txt", "r");

    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {
        int length = strlen(line);

        char part1[length/2 + 1];
        char part2[length/2 + 1];

        // filling substrings
        for (int i = 0; i < length/2; i++) {
            part1[i] = line[i];
            part2[i] = line[i + length/2];
        }
        part1[length/2] = '\0';
        part2[length/2] = '\0';

        // finding matching character
        char matchingChar = ' ';
        for (int i = 0; i < length/2; i++) {
            char c = part1[i];
            for (int j = 0; j < length/2; j++) {
                if (c == part2[j]) {
                    matchingChar = c;
                    break;
                }
            }
        }

        // calculating priority
        int priority;
        if (matchingChar >= 'a')    // small letters
            priority = matchingChar - 96;
        else                        // capital letters
            priority = matchingChar - 38;

        prioritySum += priority;
    }
    fclose(file);

    printf("%d", prioritySum);
    return 0;
}
