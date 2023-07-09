import sys

N, M = map(int, sys.stdin.readline().split())

hlist = [sys.stdin.readline().strip() for _ in range(N)]
slist = [sys.stdin.readline().strip() for _ in range(M)]

arr = sorted(list(set(hlist) & set(slist)))

print(len(arr))
for i in sorted(arr):
    print(i)