def divby11(i):
   tmp = int(i)
   while (i > 9):
                
                d = i % 10
                i = int((i - d)/10)
                i -= d
                print( i)
   if i == 0:
      print("The number " + str(tmp) + " is divisible by 11!")
   else:
      print("The number " + str(tmp) + " is  not divisible by 11.")

divby11(12345678901234567900)
