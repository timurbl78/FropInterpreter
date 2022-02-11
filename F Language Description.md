# About the Language

The program written on F is a sequence of elements (either atoms or literals).
There are three kinds of entities defined in the language.

* Literals 

  Literals are just values that are written explicitly. There are integer, real and boolean literals. 

* Atoms

  Atoms represent variables which can have values (a value of a literal, or a list). 

* Lists

  List is a sequence of elements separated by whitespaces and enclosed by parentheses. Some lists have a special meaning. If a list starts with a keyword it is called special form.

* The keywords of the special forms are:

  **_quote   setq   func   lambda   prog   cond   while   return  break_**

## Special forms

Special forms introduce language notions that have some predefined meaning. Each special form is actually a list where the very first element is a keyword. The rest of the special form can contain a number of Elements that are specific for each special form.

* ( setq Atom Element )
  Performs assignment a value to an atom. The second parameter gets evaluated, and the evaluated value becomes the new value of the atom from the fist parameter replacing its previous value. If there was not an atom with the given name in the current context then it is created and added to the context. 

  (setq x 5)
  (setq y (plus 1 2)) // atom y gets the value of 3 
  (setq z null)

* ( quote Element ) 
  'Element
  The function just returns its argument without evaluating it. Single quote sign in front of an element is the short form of the function.

  (setq x (plus 1 2)) // x gets the value of 3
  x // the value of 3
  'x // the atom x itself
  
* ( func Atom List Element )
  Introduces a new user-defined function. The first argument - the name of the function. The second contains the function parameters. The third is the body of the function.
  Each user-defined function introduces its own local context: atoms representing parameters are local to the function. They disappear after exiting from the function.
  Only three special forms introduce local contexts: func, lambda, and prog.

  (func Cube (arg) (times (times arg arg) arg)) 
  (func Trivial () 1)

## Program Execution

The program execution starts from its very first element. Each element is evaluated in accordance with its semantics. If the current element is an atom -> simply return its value. If it is a list -> call to a function, whose name is the name of the first list element, and the other list elements are considered arguments of the call.

## Language Grammar

Program : Element { Element } 
List : ( Element { Element } ) 
Element : Atom | Literal | List 
Atom : Identifier
Literal : [+|-] Integer | [+|-] Real | Boolean | null 
Identifier : Letter { Letter | DecimalDigit }
Letter : Any Unicode character that represents a letter 
Integer : DecimalDigit { DecimalDigit }
DecimalDigit : 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 Real : Integer . Integer
Boolean : true | false
