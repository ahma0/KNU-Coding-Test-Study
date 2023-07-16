import sys

N = list(map(int, sys.stdin.readline().strip()))
numSet = [0] * 9 # 9는 6으로 계산

for i in N:
    if i == 9:
        numSet[6] += 1
    else:
        numSet[i] += 1

if numSet[6]%2 == 0:
    numSet[6] = numSet[6]//2
else:
    numSet[6] = numSet[6]//2 + 1

print(max(numSet))
