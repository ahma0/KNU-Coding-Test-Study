import sys

N = int(sys.stdin.readline())

mem = [[i] for i in range(N)]

for i in range(N):
    age, name = sys.stdin.readline().split()
    mem[i].append(int(age))
    mem[i].append(name)


mem.sort(key=lambda x: (x[1], x[0]))

for i in range(N):
    print(mem[i][1], mem[i][2])
