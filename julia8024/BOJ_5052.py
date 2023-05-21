import sys

t = int(sys.stdin.readline())

def checkConsis():
    result = "YES"
    N = int(input())
    phones = []
    phones = list(sys.stdin.readline().rstrip() for _ in range(N))
    phones.sort()

    for j in range(N-1):
        if phones[j] in phones[j+1][:len(phones[j])]:
            result = "NO"
            break
    
    return result

for i in range(t):
    print(checkConsis())
