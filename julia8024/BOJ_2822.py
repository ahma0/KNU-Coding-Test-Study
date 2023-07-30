import sys

scores = [int(sys.stdin.readline()) for _ in range(8)]
nums = []

sorted_arr = sorted(scores, reverse=True)[:5]

for idx, val in enumerate(scores):
    if val in sorted_arr:
        nums.append(idx+1)

print(sum(sorted_arr))
print(" ".join(list(map(str, nums))))