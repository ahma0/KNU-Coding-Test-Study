import sys
from collections import Counter

N = int(sys.stdin.readline())
arrN = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
arrM = list(map(int, sys.stdin.readline().split()))

C = Counter(arrN)

print(' '.join(f'{C[m]}' if m in C else '0' for m in arrM))