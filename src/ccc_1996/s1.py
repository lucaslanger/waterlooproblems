
def defperabu(i):
	sum_factors = 0
	for f in range(1,int(i/2+1)):
		if i % f == 0:
			sum_factors += f
	if sum_factors > i:
		print (str(i) + " is an abundant number")
	elif sum_factors == i:
		print (str(i) + " is a perfect number")
	else:
		print (str(i) + " is a deficient number")

defperabu(4)
			
