(func map (f l)
  (cond 
    (isnull (head l)) (quote ())
    (cons (f (head l)) (map f (tail l)))))

(map (lambda (n) (times n n)) (1 2 3 4)) 
