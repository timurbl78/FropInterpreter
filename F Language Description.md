# About the Language

The program written on F is a sequence of elements (either atoms or literals).
There are three kinds of entities defined in the language.

* Literals <br />
  Literals are just values that are written explicitly. There are integer, real and boolean literals. 

* Atoms <br />
  Atoms represent variables which can have values (a value of a literal, or a list). 

* Lists <br />
  List is a sequence of elements separated by whitespaces and enclosed by parentheses. Some lists have a special meaning. If a list starts with a keyword it is called special form.

* The keywords of the special forms are: <br />
  **_quote   setq   func   lambda   prog   cond   while   return  break_**
  
## Program Execution

The program execution starts from its very first element. Each element is evaluated in accordance with its semantics. If the current element is an atom -> simply return its value. If it is a list -> call to a function, whose name is the name of the first list element, and the other list elements are considered arguments of the call.

## Special forms

Special forms introduce language notions that have some predefined meaning. Each special form is actually a list where the very first element is a keyword. The rest of the special form can contain a number of Elements that are specific for each special form.

* ( setq Atom Element ) <br />
  Performs assignment a value to an atom. The second parameter gets evaluated, and the evaluated value becomes the new value of the atom from the fist parameter replacing its previous value. If there was not an atom with the given name in the current context then it is created and added to the context. 

  (setq x 5) <br />
  (setq y (plus 1 2)) // atom y gets the value of 3 <br />
  (setq z null)

* ( quote Element ) <br />
  'Element <br />
  The function just returns its argument without evaluating it. Single quote sign in front of an element is the short form of the function.

  (setq x (plus 1 2)) // x gets the value of 3 <br />
  x // the value of 3 <br />
  'x // the atom x itself 
  
* ( func Atom List Element ) <br />
  Introduces a new user-defined function. The first argument - the name of the function, the second contains the function parameters, the third is the body of the function. <br />
  Each user-defined function introduces its own local context: atoms representing parameters are local to the function. They disappear after exiting from the function. <br />
  Only three special forms introduce local contexts: func, lambda, and prog.

  (func Cube (arg) (times (times arg arg) arg)) <br />
  (func Trivial () 1) <br />
  
* ( lambda List Element ) <br />
  Introduces a new user-defined unnamed function. The first argument contains the function parameters, the second is the body of the function. <br /> 
  The unnamed function can further be called by that name of an atom that gets it as the value, or directly.

  (lambda () (1 2 3 4)) <br /> 
  (setq myFunc (lambda (p) (cond (less p 0) plus minus))) <br /> 
  ((myFunc -1) 1 2) // returns 3
  
* ( prog List Element ) <br /> 
  Introduces a sequence of elements that are to be evaluated sequentially. The first parameter is the list of atoms that represent the local context of the form. The second argument contains elements that are to be evaluated sequentially. 

* ( cond Element1 Element2 [ Element3 ] ) <br /> 
  Conditional evaluation. It contains two or three arguments. The evaluation of the form starts from evaluating its first argument. The result of the evaluation should be of type boolean. If the result is true the second argument is evaluated, and the result becomes the result of the whole form. Otherwise, the third argument is evaluated and the result becomes the result of the whole form. If the result of the first argument is false and there is no third argument in the form, the result of the whole form is null.
  
* ( while Element Element ) <br /> 
  The form specifies repetitions. If the result of the first argument is true then the second argument is evaluated, and the control goes back for evaluating of the first argument again. In other words, the first argument is evaluated before each iteration. If the result is false then the evaluation of the form finishes. The result of the form is always null.
  
* ( return Element ) <br /> 
  It evaluates its argument and interrupts the execution of the nearest enclosing form with the context. If there is no such enclosing form then the whole program terminates.
  
* ( break ) <br /> 
  The form makes sense within a while form. It unconditionally interrupts the execution of the nearest while form. If there is no such enclosing form then the whole program terminates.
  
## Predefined functions

All predefined functions perform some actions on their arguments and return some result. The result can be an atom, a list, a literal, or null. Function calls are represented as lists where the first element is atom (identifier) that is the name of the function being called. <br /> 
The common algorithm of function call evaluation is as follows: <br /> 
1. All arguments are evaluated. The evaluation order is from the first argument to the last one.
2. The results of argument evaluation are passed to the function.
3. If the current value of an argument doesn’t meet the function requirements, the
whole program stops execution.
4. The function accepts evaluated arguments and performs actions specific to this particular function.
4. After completing the function’s actions, a value is returned to the calling function. 

### Arithmetic functions
* ( plus Element Element)
* ( minus Element Element )
* ( times Element Element )
* ( divide Element Element )

Arithmetic functions have two parameters. After their evaluation, the arguments should be of an integer or real value (the result of the corresponding action).

### Operations on lists
* ( head List ) / returns the first element of the list 
* ( tail List ) / returns the initial list without its first element
* ( cons Element List ) / constructs a new list adding its first argument as the first element to the list from the second argument. The function returns the list constructed.

### Comparisons
* ( equal Element Element )
* ( nonequal Element Element )
* ( less Element Element )
* ( lesseq Element Element )
* ( greater Element Element )
* ( greatereq Element Element )

After evaluation, the arguments should be of type integer, real, or boolean. The functions perform usual comparisons and return a boolean value depending on the result of comparison.

### Predicates
* ( isint Element )
* ( isreal Element )
* ( isbool Element )
* ( isnull Element )
* ( isatom Element )
* ( islist Element )

After evaluation, the arguments should be of any type. The functions return a boolean value: true, if the argument is of type that the function expects, and false otherwise.

### Logical operators
* ( and Element Element )
* ( or Element Element )
* ( xor Element Element )
* ( not Element )

After evaluation, the arguments should be of boolean type. The functions perform usual logical operators on evaluated arguments and return a boolean value.

### Evaluator
* ( eval Element )

After evaluation, the argument should be of any type. If the argument if a list then the function treats it as a valid program and tries to evaluate it. In that case, the function returns the value that the program issues. If the argument is a literal or atom the function just return the argument.

## Language Grammar

Program : Element { Element } <br />
List : ( Element { Element } ) <br />
Element : Atom | Literal | List <br />
Atom : Identifier <br />
Literal : [+|-] Integer | [+|-] Real | Boolean | null <br />
Identifier : Letter { Letter | DecimalDigit } <br />
Letter : Any Unicode character that represents a letter <br />
Integer : DecimalDigit { DecimalDigit } <br />
DecimalDigit : 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 Real : Integer . Integer <br />
Boolean : true | false 
