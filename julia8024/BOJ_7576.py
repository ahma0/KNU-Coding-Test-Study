import sys
from collections import deque

M, N = map(int, sys.stdin.readline().split())

box = []
tomato = []

for i in range(N):
    box.append(list(map(int, sys.stdin.readline().split())))
    for j in range(M):
        if box[i][j] == 1:
            tomato.append((0, i, j))

d = [(0,1), (0,-1), (1,0), (-1,0)]

q = deque(tomato)

while q:
    day, x, y = q.popleft()

    for dx, dy in d:
        X, Y = x+dx, y+dy
        if 0 <= X < N and 0 <= Y < M and box[X][Y] ==0:
            box[X][Y] = 1
            q.append((day+1, X, Y))

for i in range(N):
    if 0 in box[i]:
        print(-1)
        sys.exit(0)

print(day)

