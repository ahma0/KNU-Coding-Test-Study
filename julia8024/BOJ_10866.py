import sys

N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    temp = sys.stdin.readline().split()
    length = len(arr)

    if temp[0] == "push_front":
        arr.insert(0, temp[1])
    elif temp[0] == "push_back":
        arr.append(temp[1])
    elif temp[0] == "pop_front":
        print(arr.pop(0) if length != 0 else -1)
    elif temp[0] == "pop_back":
        print(arr.pop() if length != 0 else -1)
    elif temp[0] == "size":
        print(length)
    elif temp[0] == "empty":
        print(1 if length == 0 else 0)
    elif temp[0] == "front":
        print(arr[0] if length != 0 else -1)
    elif temp[0] == "back":
        print(arr[-1] if length != 0 else -1)
        