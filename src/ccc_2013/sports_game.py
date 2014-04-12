def solveSoccerProblem(teamnumber, gp, gamedata):
    
    wins = 0
    
    teamnumber = int(teamnumber)
    s_scores = [0,0,0,0]
    games_to_play = ["12","13","14","23","24","34"]
    tn = teamnumber
    for gi in range( int(gp) ):
        mod_scores(s_scores, gamedata[gi])
        games_to_play.remove(  gamedata[gi][0] + gamedata[gi][2]  )
        
    p_out = getPossibleOutcomes(len(games_to_play) )
     
    for p in p_out:
        wins += testWin(s_scores, games_to_play, p, teamnumber )
        
    print wins

def mod_scores(s_scores, gd):
    vals = [int(a) for a in gd.split(" ")]
    t1 = vals[0]
    t2 = vals[1]
    s1 = vals[2]
    s2 = vals[3]
    
    if s1 > s2:
        s_scores[t1-1] += 3
    elif s1 == s2:
        s_scores[t1-1] += 1
        s_scores[t2-1] += 1
    elif s1 < s2:
        s_scores[t2-1] += 3
        

def testWin(s_score, gtp, outcome, tnum):
    
    score = list(s_score)
    #print gtp
    #print score, outcome
    for g in range(len(gtp)):
        t = int(outcome[g])
        if t == 0:
            #print outcome[g] + "test"
            score[int(gtp[g][0]) - 1] += 3
            
        elif t == 1:
            score[int(gtp[g][1]) - 1] += 3
            #print outcome[g] + "test2"
        else:
            score[int(gtp[g][0]) - 1] += 1
            score[int(gtp[g][1]) - 1] += 1
            
    
         
    for i in range(4):
        if i != tnum-1 and score[i] >= score[tnum-1]:
                  
            return 0
    #print score, tnum   
    return 1

def getPossibleOutcomes(nGames):
    combs = 3**(nGames)
    outcomes = ["" for i in range(combs) ]
    
    for g in range(nGames):
        rng = combs/(3**(g+1))
        for i in range(rng):
            for o in range(3):
                thickness = 3**g
                for k in range( thickness ):
                    
                    iFactor = i*(3**(g+1))
                    oFactor = o * (3**g)
                    outcomes[iFactor + oFactor + k ] = str(o)+outcomes[iFactor + oFactor + k ]
    
    return outcomes
    
    
f = open("s3.2.in.txt")
s = f.readlines()
solveSoccerProblem(s[0], s[1], s[2:])