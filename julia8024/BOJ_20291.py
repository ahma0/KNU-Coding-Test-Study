import sys

N = int(sys.stdin.readline())
data = [sys.stdin.readline().strip().split('.')[-1] for _ in range(N)]

_dict = {}

for i in set(data):
    _dict[i] = 0

for i in data:
    _dict[i] += 1

result = dict(sorted(_dict.items()))

for k,v in result.items():
    print(k, v)
