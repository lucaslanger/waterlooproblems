def runtest(input1):

    carts_top = [int(a) for a in input1]
    carts_side = []
    lC = -1
    
    debug = False
    
    
    possible = True
    
    while len(carts_top) !=0 or len(carts_side) !=0:
        
        
        if len(carts_top) > 0:
            cT = carts_top[-1]
        else:
            cT = None
        
        if len(carts_side) >0:
            cS = carts_side[-1]
        else:
            cS = None
            
        #print cT, cS
        
        if cS and lC > cS: #if there exists a cart that needs to pass, but that is skinnier than prev high, it fails
            possible = False
            break
            
        elif cT and lC > cT:
            possible = False
            break
        
        elif cT == None or (cT >= cS and cS != None) :
            lC = carts_side.pop()
        
        elif cS == None or (cS > cT and cT != None):
            carts_side.append( carts_top.pop() )
               
            
    if possible:
        print "Yes"
        
    else:
        print "No"
        
        
        
f = open("s3.3.in.txt", "r")
avals = f.readlines()[1:]
f.close()

i = 0
while True:
    try:
        length_test = int(avals[i])
        runtest(avals[i+1:i + length_test+1])
        i = i + length_test + 1
    except IndexError, e:
        print str(e)
        break


