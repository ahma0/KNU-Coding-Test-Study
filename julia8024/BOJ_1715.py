import sys

N = int(sys.stdin.readline())

arr = sorted([int(sys.stdin.readline()) for _ in range(N)])

temp = []
sumCard = 0

arr.insert(0, arr.pop(0) + arr.pop(0))

for i in range(len(arr)):
    sumCard += sum(arr[:i+1])

print(sumCard)

# 시간초과 뜸