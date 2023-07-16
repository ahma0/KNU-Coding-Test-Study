import sys

T = int(sys.stdin.readline())

arr = [int(sys.stdin.readline()) for _ in range(T)]
seq = [1,1,1,2,2]

for i in range(5, max(arr)):
    seq.append(seq[i-1] + seq[i-5])

for i in arr:
    print(seq[i-1])
