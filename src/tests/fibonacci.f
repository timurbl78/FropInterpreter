(func fibonacci (n)
  (cond 
    (less n 2) 1 
    (plus (fibonacci (minus n 1)) (fibonacci (minus n 2)))))

(fibonacci 10)
