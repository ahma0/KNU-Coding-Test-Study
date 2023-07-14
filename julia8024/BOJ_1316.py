import sys

N = int(sys.stdin.readline())
cnt = 0

for i in range(N):
    strings = list(map(str, sys.stdin.readline().strip()))
    temp = [strings[0]]

    for idx, s in enumerate(strings):
        if idx == 0:
            temp.append(s)
        elif s != strings[idx-1]:
            if s in temp:
                cnt += 1
                break
            else:
                temp.append(s)

print(N-cnt)