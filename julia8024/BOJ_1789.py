S = int(input())

sumNum = 0
cnt = 0
    
for i in range(1, S+1):
    sumNum += i
    cnt = i
    if S < sumNum:
        cnt -= 1
        break

print(cnt-1)