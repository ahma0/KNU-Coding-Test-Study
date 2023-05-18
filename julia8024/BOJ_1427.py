import sys

st = str(int(sys.stdin.readline()))
print(''.join(sorted(st, reverse=True)))