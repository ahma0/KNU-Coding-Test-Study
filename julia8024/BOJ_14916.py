# [BOJ] 거스름돈 / 실버 5 / 15분

import sys

N = int(sys.stdin.readline())
cnt = 0

if (N == 1 or N == 3):
    print(-1)
else:
    cnt += N//5
    N = N%5

    if N%2 != 0:
        N +=5
        cnt -=1

    cnt += N//2
    print(cnt)