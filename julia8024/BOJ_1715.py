import sys
import heapq

N = int(sys.stdin.readline())
arr = []

for i in range(N):
    heapq.heappush(arr, int(sys.stdin.readline()))

result = 0

if len(arr)==1:
    print(result)
else:
    for i in range(N-1):
        prev = heapq.heappop(arr)
        curr = heapq.heappop(arr)

        result += prev + curr
        heapq.heappush(arr, prev+curr)

    print(result)