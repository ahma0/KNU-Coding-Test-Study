import sys

N = int(sys.stdin.readline())
data = [int(sys.stdin.readline()) for _ in range(N)]

for i in sorted(data, reverse=True):
    print(i)