def compare(left, right): # 1,0 - good -> -1 - again
    if type(left) == int and type(right) == int:
        if left < right:
            return 1
        if left > right:
            return 0
        if left == right:
            return -1
    if type(left) == list and type(right) == list:
        if len(right) == 0 and len(left) == 0:
            return -1
        if len(right) == 0:
            return 0
        if len(left) == 0:
            return 1
        while True:
            res = compare(left[0], right[0])
            if res in [1, 0]:
                return res
            left.pop(0)
            right.pop(0)
            if len(left) == 0 and len(right) == 0:
                return -1
            if len(left) == 0:
                return 1
            if len(right) == 0:
                return 0
    if type(left) == int and type(right) == list:
        return compare([left], right)
    if type(right) == int and type(left) == list:
        return compare(left, [right])
    return compare(left, right)


pair = []
with open('input.txt') as file:
    for line in file.readlines():
        if len(line) > 1:
            pair.append(eval(line))

sum = 0

for i in range(0, len(pair) - 1, 2):
    left = pair[i]
    right = pair[i + 1]
    res = compare(left, right)
    if res == 1:
        sum += (i / 2) + 1
print(sum)


