computer = int(input())
couples = int(input())

data = [[]*computer for _ in range(computer+1)]

for _ in range(couples):
    a, b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

cnt = 0

visited = [0] * (computer+1)
def dfs(start):
    global cnt
    visited[start] = 1
    for i in data[start]:
        if visited[i]==0:
            dfs(i)
            cnt+=1

dfs(1)
print(cnt)