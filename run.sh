#!bash
javac -sourcepath ./src -d bin ./src/Main/Main.java
java -classpath ./bin Main.Main $1