(func range (a b)
  (cond 
    (equal a b) (quote ()) 
    (cons a (range (plus a 1) b))))

(range 0 10)
