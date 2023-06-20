N = int(input())
arr = []

for i in range(N):
    temp = int(input())
    if temp == 0:
        arr.pop()
    else:
        arr.append(temp)

print(sum(arr))