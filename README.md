# FropInterpreter

Our team creates an interpreter for the F language. It is a functional language, which can be considered as a reduced version of Lisp with some simplifications and modifications. 

**Technology Stack**
We decided to choose Java for writing an interpreter. Also, we are using Bison for automated parser generation.

**Description of the language**
Description/documentation of the language is provided in a separate .md file in the same repository.

**How to get started**
Having Java installed, clone this repository to your machine.

Note that you need to have an opportunity to run shell scripts.
Linux and MacOS usually have bash from the box.
For Windows one install, for example, Cmder: [installation guide](https://medium.com/@sithum/cmder-the-best-way-to-run-linux-shell-bash-commands-and-scripts-in-windows-cfe2d36d1028).

Then in root directory of the project run the command:

`sh ./run.sh path_to_file`

where path_to_file is absolute or relative path to file that is to be interpreted and executed.

**How to change interpreter**
If you want to change the work of interpreter, you'll need GNU Bison installed to change parser.y file.
Then you are free to add new built-in functions and change the behavior of interpreter.