(func listsum (l)
  (cond 
    (isnull (head l)) 0
    (plus (head l) (listsum (tail l)))))
    
(listsum (1 2 3 4 5))
