#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int areCharactersDifferent(char* arr) {
    for (int i = 0; i < strlen(arr); i++) {
        for (int j = 0; j < strlen(arr); j++) {
            if (i == j)
                continue;
            if (arr[i] == arr[j])
                return 0;
        }
    }
    return 1;
}

int main() {
    char line[5000];
    int result = 0;
    int result2 = 0;

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        printf("File not found!");
        return 1;
    }

    while (fgets(line, sizeof(line), file)) {

        // part 1
        for (int i = 3; i < strlen(line); i++) {
            char chars[5];
            for (int j = 0; j < 4; j++) {
                chars[j] = line[i - j];
                chars[j+1] = '\0';
            }
            if (areCharactersDifferent(chars)) {
                result = i + 1;
                break;
            }
        }

        // part 2
        for (int i = 13; i < strlen(line); i++) {
            char chars2[14];
            for (int j = i, k = 0; j >= i - 13; j--, k++) {
                chars2[k] = line[j];
                chars2[k+1] = '\0';
            }
            if (areCharactersDifferent(chars2)) {
                result2 = i + 1;
                break;
            }
        }
    }
    printf("%d\n", result);
    printf("%d", result2);
    return 0;
}
