import sys

N = int(sys.stdin.readline())
data = list(sys.stdin.readline().strip() for _ in range(N))

_dict = {str:0 for str in set(data)}

for i in data:
    if i in _dict:
        _dict[i] += 1

print(sorted([k for k, v in _dict.items() if max(_dict.values()) == v])[0])