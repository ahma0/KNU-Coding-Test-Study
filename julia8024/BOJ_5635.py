import sys

N = int(sys.stdin.readline())

arr = []

for i in range(N):
    n, d, m, y = sys.stdin.readline().split()
    d, m, y = map(int, (d,m,y))
    arr.append((y,m,d,n))

arr.sort()

print(arr[-1][-1])
print(arr[0][-1])