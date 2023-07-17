import sys

N = int(sys.stdin.readline())

arr = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

cnt = 0 # 단지 수
apt = [] # 단지내 집의 수
global temp
d = [(0,1), (0,-1), (1,0), (-1,0)]


def dfs(x, y):
    global temp
    visited[y][x] = True

    for dx, dy in d:
        X, Y = x+dx, y+dy
        if (0 <= X < N) and (0 <= Y < N):
            if visited[Y][X] == False and arr[Y][X]:
                temp += 1
                dfs(X, Y)


for y in range(N):
    for x in range(N):
        temp = 1
        if visited[y][x] == False and arr[y][x]:
            dfs(x, y)
            cnt += 1
            apt.append(temp)

print(cnt)
for i in sorted(apt):
    print(i)



