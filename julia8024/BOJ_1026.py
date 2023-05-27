N = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

print(sum(sorted(a)[i] * b.pop(b.index(max(b))) for i in range(N)))