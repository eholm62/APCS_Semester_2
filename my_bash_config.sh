#!/bin/bash
# run from the base 
# directory of the 
# project by typing
# . my_bash_config.sh
# do this every time 
# you update the file 
# or open a new terminal

unalias -a

# aliases
alias javac="javac -classpath .:`pwd`/StdLib"
alias java="java -classpath .:`pwd`/StdLib"

echo success
