
def getLen(n):
    count = 1
    while n != 1:
        if n%2 != 0:
            n = 3*n + 1
        else:
            n = n//2
        count += 1
    return count


while True:
    a, b = map(int, input().split(" "))
    maxLen = 0
    for i in range(min(a,b), max(a,b) + 1):
        length = getLen(i)
        if length > maxLen:
            maxLen = length

    print(a,b,maxLen)


