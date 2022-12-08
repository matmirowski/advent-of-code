
files = {'/': 0}
data = []

with open('input.txt') as file:
    for line in file.readlines():
        data.append(line.split(' '))

for line in data:
    if line[0] == 'dir':
        files[line[1].strip()] = 0

for i in range(len(data)):
    line = data[i]
    if line[0].isnumeric(): # nowy plik
        counter = 1
        while True:
            back_line = data[i-counter]
            if back_line[1] == 'cd' and back_line[2].strip() != '..':
                folder = back_line[2].strip()
                files[folder] = int(line[0]) + files.get(folder)
                break
            counter += 1

for i in range(len(data)):
    line = data[i]
    if line[0] == 'dir':
        counter = 1
        while True:
            back_line = data[i-counter]
            if back_line[1] == 'cd' and back_line[2].strip() != '..':
                files[back_line[2].strip()] = files.get(back_line[2].strip()) + files.get(line[1].strip())
                break
            counter += 1

sum_file_sizes = 0

for value in files.values():
    if value <= 100000:
        sum_file_sizes += value

print(sum_file_sizes)
