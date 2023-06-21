T = int(input())

for i in range(T):
    arr = input()
    temp = []
    for j in arr:
        if j == "(":
            temp.append(j)
        elif j == ")" and len(temp) != 0:
            temp.pop(0)
        else:
            temp.append(")")
            break

    if len(temp) == 0:
        print("YES")
    else:
        print("NO")