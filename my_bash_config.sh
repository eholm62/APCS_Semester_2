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
alias jdb="jdb -sourcepath .:/workspaces/APCS_Semester_2/StdLib -classpath .:/workspaces/APCS_Semester_2/StdLib"

echo success
