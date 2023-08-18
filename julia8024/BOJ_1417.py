import sys

N = int(sys.stdin.readline())

arr = [int(sys.stdin.readline()) for _ in range(N)]
cnt = 0

while True:
    if (arr[0] == max(arr) and arr.count(max(arr)) == 1):
        break
    
    idx = arr.index(max(arr), 1, N)
    arr[idx] -= 1
    arr[0] += 1
    cnt += 1

print(cnt)