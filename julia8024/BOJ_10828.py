import sys

N = int(sys.stdin.readline())
data = []

for i in range(N):
    cmd = sys.stdin.readline().split()

    if cmd[0] == 'push':
        data.append(int(cmd[1]))
    elif cmd[0] == 'pop':
        print(data.pop() if len(data) != 0 else -1)
    elif cmd[0] == 'top':
        print(data[-1] if len(data) != 0 else -1)
    elif cmd[0] == 'size':
        print(len(data))
    elif cmd[0] == 'empty':
        print(1 if len(data)==0 else 0)
