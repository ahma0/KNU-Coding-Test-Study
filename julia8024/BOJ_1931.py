import sys

N = int(sys.stdin.readline())
data = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

data.sort(key=lambda x : x[0])
data.sort(key=lambda x : x[1])

cnt = 0
last_end = 0

for start, end in data:
    if start >= last_end:
        cnt+=1
        last_end = end

print(cnt)