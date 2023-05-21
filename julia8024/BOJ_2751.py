import sys

N = int(sys.stdin.readline())
data = sorted([int(sys.stdin.readline()) for _ in range(N)])
for i in data:
    print(i)