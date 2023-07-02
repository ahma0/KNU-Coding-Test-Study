import sys

st = sys.stdin.readline().rstrip()
explos = sys.stdin.readline().rstrip()

stack = []

for i in range(len(st)):
    stack.append(st[i])
    if ''.join(stack[-len(explos):]) == explos:
        for _ in range(len(explos)):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')