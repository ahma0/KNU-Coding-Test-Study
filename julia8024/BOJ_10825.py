import sys

N = int(sys.stdin.readline())
arr = [list(sys.stdin.readline().split()) for _ in range(N)]

arr.sort(key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in arr:
    print(str(i[0]))