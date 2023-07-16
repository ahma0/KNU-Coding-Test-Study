# 프로그래머스 - 타겟 넘버

def solution(numbers, target):
    leaves = [0]
    cnt = 0
    
    for num in numbers:
        temp = []
        
        for i in leaves:
            temp.append(i + num)
            temp.append(i - num)
        
        leaves = temp
    
    for i in leaves:
        if i == target:
            cnt += 1
    
    return cnt
            