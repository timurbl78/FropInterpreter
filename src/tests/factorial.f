(func factorial (n) (lambda (n) 
  (cond 
    (lesseq n 1) 1 
    (times n (factorial (minus n 1))))))

(factorial 10)
