import sys

chem = list(map(str, sys.stdin.readline().strip()))
_dict = {"H":1, "C":12, "O":16}
stack = []

for i in chem:
    if i == "(":
        stack.append(i)
    elif i == ")":
        check =  0
        
        while True:
            temp = stack.pop()
            if temp == "(":
                break
            
            check += temp
        
        stack.append(check)
    
    elif i in _dict:
        stack.append(_dict[i])
    else:
        stack[-1] *= int(i)

print(sum(stack))
