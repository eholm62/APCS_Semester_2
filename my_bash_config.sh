#!/bin/bash

# run from the base 
# directory of the 
# project by typing
# . my_bash_config.sh
# do this every time  
# you open a new terminal
# after running once in 
# the base directory you
# can run from any dir
# by typing config_bash
# until you open a new 
# terminal

# $base_dir will be replaced
# with the absolute path
# to the home directory

# success does not 
# necessarily mean that
# no errors occured, but
# rather that nothing
# stopped the execution
# of the file

unalias -a

if [ "$_already_run" != 1 ]; then 
    export base_dir=`pwd`
    echo config_bash command and base_dir variable are now defined
fi
export _already_run=1
alias config_bash=". $base_dir/my_bash_config.sh"


# aliases
alias javac="javac -classpath .:$base_dir/StdLib"
alias java="java -classpath .:$base_dir/StdLib"
alias jdb="jdb -sourcepath .:$base_dir/StdLib -classpath .:$base_dir/StdLib"


echo success
