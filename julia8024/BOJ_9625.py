import sys

N = int(sys.stdin.readline())

A = [1, 0]
B = [0, 1]

for i in range(2, N+1):
    cntA = A[i-1] + A[i-2]
    A.append(cntA)
    cntB = B[i-1] + B[i-2]
    B.append(cntB)

print(A[N], B[N])