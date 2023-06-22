import sys

N = int(sys.stdin.readline())
stack = []

for i in range(N):
    oper = list(map(str, sys.stdin.readline().split()))
    if oper[0] == "push":
        stack.append(oper[1])
    elif oper[0] == "pop":
        print(stack.pop(0) if len(stack) != 0 else -1)
    elif oper[0] == "size":
        print(len(stack))
    elif oper[0] == "empty":
        print(1 if len(stack) == 0 else 0)
    elif oper[0] == "front":
        print(stack[0] if len(stack) != 0 else -1)
    elif oper[0] == "back":
        print(stack[-1] if len(stack) != 0 else -1)
    
    