# 프로그래머스 - 네트워크

def solution(n, computers):
    
    def dfs(v):
        visited[v] = True
        
        for i in range(n):
            if not visited[i] and computers[v][i]:
                dfs(i)
        
    visited = [False] * (n)
    cnt = 0
    
    for i in range(n):
        if not visited[i]:
            dfs(i)
            cnt += 1
    
    return cnt