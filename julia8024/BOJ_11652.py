import sys
N = int(sys.stdin.readline())
dict_ = {}

for i in range(N):
    temp = int(sys.stdin.readline())
    if temp in dict_:
        dict_[temp] += 1
    else:
        dict_[temp] = 1

dict_ = sorted(dict_.items(), key=lambda x: (-x[1], x[0]))
print(dict_[0][0])