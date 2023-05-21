import sys

while True:
    N = int(sys.stdin.readline())
    if N == 0:
        break
    data = [sys.stdin.readline().strip() for _ in range(N)]
    data_lower = [data[i].lower() for i in range(N)]
    first = sorted(data_lower)[0]

    for i in data:
        if first == i.lower():
            result = i
            break
    
    print(result)
