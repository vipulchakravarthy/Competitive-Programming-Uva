flag = True
while True:
	try:
		n = input()
	except:
		break
	out = []
	for c in n:
		if c ==  "\"":
			if flag:
				out.append("``")
			else:
				out.append("''")
			flag = not flag
		else:
			out.append(c)
	print("".join(out))



