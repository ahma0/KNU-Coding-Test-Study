import sys

N = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

print(" ".join(str(i) for i in sorted(list(set(data)))))

