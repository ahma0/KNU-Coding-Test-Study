import sys

N, K = map(int, sys.stdin.readline().split())

arr = sorted([int(sys.stdin.readline()) for _ in range(N)], reverse=True)

cnt = 0
for i in arr:
    if K >= i:
        cnt += K // i
        K %= i
        if K <= 0:
            break
        
print(cnt)