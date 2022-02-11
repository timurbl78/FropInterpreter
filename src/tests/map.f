(func map (f l) (lambda (f l)
  (cond 
    (isnull l) (quote ())
    (cons (f (car l)) (map f (cdr l))))))

(map (lambda (n) (times n n)) (1 2 3 4)) 
