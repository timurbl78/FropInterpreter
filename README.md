# FropInterpreter

Our team creates an interpreter for the F language. It is a functional language, which can be considered as a reduced version of Lisp with some simplifications 
and modifications. 

## About the Language

The program wretten on F is a sequence of elements (either atoms or literals).
There are three kinds of entities defined in the language.

* Literals 

  Literals are just values that are written explicitly. There are integer, real and boolean literals. 

* Atoms

  Atoms represent variables which can have values (a value of a literal, or a list). 

* Lists

  List is a sequence of elements separated by whitespaces and enclosed by parentheses. Some lists have a special meaning. If a list starts with a keyword it is called special form.

* The keywords of the special forms are:

  **_quote   setq   func   lambda   prog   cond   while   return  break_**

* Special forms

  Special forms introduce language notions that have some predefined meaning. Each special form is actually a list where the very first element is a keyword. The rest of the special form can contain a number of Elements that are specific for each special form.

## Program Execution

The program execution starts from its very first element. Each element is evaluated in accordance with its semantics. If the current element is an atom -> simply return its value. If it is a list -> call to a function, whose name is the name of the first list element, and the other list elements are considered arguments of the call.

* Function

  The function just returns its argument without evaluating it. The meaning of the function is to prevent evaluating its argument. Using the single quote sign in front of an element is actually the short form of the function.
