from itertools import combinations

while True:
    l = list(map(int, input().split(" ")))
    k = l.pop(0)
    if k == 0:
        break
    
    perm = list(combinations(l,6))
    sorted(perm)
    for x in perm:
        st = ""
        for i in x:
            st += str(i) + " "
        print(st)
    print()