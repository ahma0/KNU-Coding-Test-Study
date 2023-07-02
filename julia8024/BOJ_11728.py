N, M = map(int, input().split())

arrA = list(map(int, input().split()))[:N]
arrB = list(map(int, input().split()))[:M]

arr = " ".join(map(str, sorted(list(arrA + arrB))))

print(arr)
