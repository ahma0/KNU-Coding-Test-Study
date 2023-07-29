import sys

for t in range(int(sys.stdin.readline())):
    N = int(sys.stdin.readline())
    note1 = set(map(int, sys.stdin.readline().split()))

    M = int(sys.stdin.readline())
    note2 = list(map(int, sys.stdin.readline().split()))

    for i in note2:
        print(1 if i in note1 else 0)
