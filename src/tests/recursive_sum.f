(func listsum (l) (lambda (l)
  (cond 
    (isnull l) 0
    (plus (head l) (listsum (tail l))))))
    
(listsum (1 2 3 4 5))
