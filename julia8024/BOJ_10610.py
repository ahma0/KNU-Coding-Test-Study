N = input()

if "0" not in N:
    print(-1)
else:
    num_sum = sum(list(map(int, str(N))))
    if num_sum % 3 != 0:
        print(-1)
    else :
        print("".join(sorted(N, reverse=True)))
    