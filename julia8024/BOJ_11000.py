import sys
import heapq

N = int(sys.stdin.readline())
data = sorted(list(list(map(int, sys.stdin.readline().split())) for _ in range(N)))

room = []
heapq.heappush(room, data[0][1])

for i in range(1, N):
    if data[i][0] < room[0]:
        heapq.heappush(room, data[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, data[i][1])

print(len(room))