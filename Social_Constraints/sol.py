from itertools import permutations

def check(a,b,c,m, seats):
    
    for i in range(m):
        # print(abs(seats[a[i]] - seats[b[i]]), c[i])
        if c[i] > 0 and abs(seats[a[i]] - seats[b[i]]) > c[i]:
            return False
        elif c[i] < 0 and abs(seats[a[i]] - seats[b[i]]) < -c[i]:
            # print(abs(seats[a[i]] - seats[b[i]]), c[i])
            return False
    return True


while True:
    inp = list(map(int, input().split(" ")))
    n = inp[0]
    m = inp[1]
    if n == 0 and m==0:
        break
    seats = []
    for i in range(n):
        seats.append(i)
    a= [0]*22
    b= [0]*22
    c= [0]*22 
    for i in range(m):
        token = list(map(int, input().split(" ")))
        a[i] = token[0]
        b[i] = token[1]
        c[i] = token[2]
    res = 0
    l = list(permutations(seats,n))
    # print(seats)
    # print(l)
    for x in range(len(l)):
        if(check(a,b,c,m, l[x])):
            res += 1
    
    print(res)