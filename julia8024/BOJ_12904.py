import sys

S = list(sys.stdin.readline().rstrip())
T = list(sys.stdin.readline().rstrip())

flag = False

while T:
    if T[-1] == 'A':
        T.pop()
    elif T[-1] == 'B':
        T.pop()
        T.reverse()
    
    if S == T:
        flag = True
        break


print(1 if flag else 0)