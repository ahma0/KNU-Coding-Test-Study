import sys

# input
N = int(sys.stdin.readline())
nlist = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
mlist = list(map(int, sys.stdin.readline().split()))

for i in range(M):
    print(1 if mlist[i] in nlist else 0)
