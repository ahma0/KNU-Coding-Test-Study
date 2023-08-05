import sys

N = int(sys.stdin.readline())

chats = {}
cnt = 0

for _ in range(N):
    temp = sys.stdin.readline().strip()

    if temp == "ENTER":
        chats = {}
    else:
        if temp not in chats:
            chats[temp] = 1
            cnt += 1
        else:
            continue

print(cnt)