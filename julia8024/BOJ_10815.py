import sys

N = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
target = list(map(int, sys.stdin.readline().split()))

_dict = {}

for i in range(N):
    _dict[data[i]] = 0

for i in range(M):
    if target[i] not in _dict:
        print(0, end=' ')
    else:
        print(1, end=' ')

