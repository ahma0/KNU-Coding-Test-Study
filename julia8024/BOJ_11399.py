N = int(input())
arr = sorted([int(x) for x in input().split()])
result = 0

for i in range(N):
    result += sum(arr[:i+1])

print(result)