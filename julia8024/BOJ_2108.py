import sys
from collections import Counter

N = int(sys.stdin.readline())

arr = sorted([int(sys.stdin.readline()) for _ in range(N)])

sumNum = sum(arr)
print(round(sumNum / len(arr)))

print(arr[len(arr)//2])

# 빈도수 높은 숫자 2개 가져오기
cnt = Counter(arr).most_common(2)

if len(arr) > 1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])

print(arr[-1] - arr[0])