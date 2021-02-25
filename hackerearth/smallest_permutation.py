t = int(input())
while t>0:

    n = int(input())
    a = [int(x) for x in input().split(' ')]

    flag =False
    for i in range(n):
        if(a[i]==(i+1)):
            continue

        else:
            for j in range(i+1,n):
                if(a[j]==(i+1)):
                    flag=True
                    tmp =a[j]
                    a[j]=a[i]
                    a[i]=tmp
                    break
        break
    
    if(flag==False and n>1):
        tmp=a[n-1]
        a[n-1]=a[n-2]
        a[n-2]=tmp

    for i in range(n):
        if i==(n-1):
            print(str(a[i]))
        else:
            print(str(a[i]),end=" ")
    
        
    t-=1
