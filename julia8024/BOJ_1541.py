fx = input().split('-')

for idx, val in enumerate(fx):
    if '+' in val:
        temp = val.split('+')
        fx.pop(idx)
        fx.insert(idx, sum(list(map(int, temp))))
    else:
        fx[idx] = int(val)

result = fx.pop(0)
for i in fx:
    result -= i

print(result)