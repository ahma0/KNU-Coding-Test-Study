import sys

M = int(sys.stdin.readline())
S = []

for _ in range(M):
    temp = sys.stdin.readline().split()
    length = len(S)

    if temp[0] == "add" and temp[1] not in set(S):
        S.append(temp[1])
    elif temp[0] == "remove" and temp[1] in set(S):
        S.remove(temp[1])
    elif temp[0] == "check":
        print(1 if temp[1] in set(S) else 0)
    elif temp[0] == "toggle":
        if temp[1] not in set(S):
            S.append(temp[1])
        else:
            S.remove(temp[1])
    elif temp[0] == "all":
        S = set(range(1, 21, 1))
        print(S)