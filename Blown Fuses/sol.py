seq = 0
while True:
	try:
		seq = seq + 1
		d={}
		line = input().split(" ")
		n = int(line[0])
		if(n==0):
			break
		m = int(line[1])
		c = int(line[2])
		i=1
		while(i<=n):
			line = int(input())
			d[i] = [line,0]
			i=i+1
		k=0
		power = 0
		maxp=0
		flag =False
		loop = False
		while(k< m):
			device = int(input())
			if not loop:
				if(d[device][1]==0):
					power = power +d[device][0]
					d[device][1] = 1
				else :
					d[device][1] = 0
					power = power -d[device][0]
				if(maxp<power):
					maxp=power
				if(power>c):
					print("Sequence",seq)
					print("Fuse was blown.")
					print()
					loop = True
					flag=True
			k=k+1
		if(flag==False):
			print("Sequence", seq)
			print("Fuse was not blown.")
			print("Maximal power consumption was "+ str(maxp) +" amperes.")
			print()

	except:
		break

