import sys

N = int(sys.stdin.readline())
data = list(set([sys.stdin.readline().strip() for _ in range(N)]))
data.sort()
data.sort(key=len)

for i in data:
    print(i)
