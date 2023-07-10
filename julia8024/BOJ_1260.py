import sys
from collections import deque

# N: 정점 개수, M: 간선 개수, V: 탐색을 시작할 정점 번호
N, M, V = map(int, sys.stdin.readline().split())

graph = [[0] * (N+1) for _ in range(N+1)] # 0번째 인덱스는 버림
dfs_visited = [False] * (N+1)
bfs_visited = [False] * (N+1)
dfs_result = []
bfs_result = []

for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph[x][y] = 1 # x->y 연결
    graph[y][x] = 1 # y->x 연결

    # [1,2] [1,3] [1,4] => [0,0,1,1,1]

def dfs(V):
    dfs_visited[V] = True
    dfs_result.append(V)
    for i in range(1, N+1):
        # 방문한 적 없고, 연결되어 있는 노드 탐색
        if not dfs_visited[i] and graph[V][i] == 1:
            dfs(i)


def bfs(V):
    bfs_visited[V] = True
    queue = deque()
    queue.append(V)
    while queue:
        temp = queue.popleft()
        bfs_result.append(temp)
        for i in range(1, N+1):
            if not bfs_visited[i] and graph[temp][i] == 1:
                queue.append(i)
                bfs_visited[i] = True
        

# dfs
dfs(V)
bfs(V)

print(' '.join(list(map(str, dfs_result))))
print(' '.join(list(map(str, bfs_result))))