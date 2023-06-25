doc = input().strip()
search = input().strip()

flag = 1
cnt = 0
i = 0

while flag == 1:

    if doc[i:i+len(search)] == search:
        cnt += 1
        i = i+len(search)
    else:
        i += 1

    if i >= len(doc):
        flag = 0

print(cnt)
