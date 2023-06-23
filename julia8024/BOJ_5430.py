import sys
from collections import deque

T = int(sys.stdin.readline())

for i in range(T):
    isError = False
    p = list(sys.stdin.readline().strip())
    n = int(sys.stdin.readline())
    tmp = sys.stdin.readline().strip()
    arr = deque(tmp[1:-1].split(','))
    if n == 0:
        arr = deque()

    R = 0
    for j in p:
        if j == "R":
            R += 1
        elif j == "D":
            if len(arr) == 0:
                print("error")
                isError = True
                break
            else:
                if R%2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
    
    if isError == False:
        if R%2 == 0:
            print('[' + ",".join(arr) + ']')
        else:
            arr.reverse()
            print('[' + ",".join(arr) + ']')

