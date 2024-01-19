#!/bin/bash

# run from the base 
# directory of the 
# project by typing
# ". my_bash_config.sh"
# do this every time  
# you open a new terminal

# after running once in 
# the base directory you
# can run from any dir
# by running "config_bash"
# unless you open a new 
# terminal in which case 
# you would need to run 
# ". my_bash_config.sh"
# from the base directory again

# if you "unalias -a" you 
# will need to run 
# ". $base_dir/my_bash_config.sh"
# in order to get the 
# "config_bash" alias back
# along with all other
# aliases

# "$base_dir" will be replaced
# by the absolute path
# to the home directory

# if you accidentally run
# ". my_bash_config.sh"
# somewhere other than 
# the base directory of 
# your project you can
# open a new terminal
# and run this file in the base
# directory or you could
# run "unset _already_run"
# then run this file in 
# the base directory

# you may want to ignore 
# most of this file 
# and simply adjust then
# lines beneath # aliases
# but you also may benefit
# from adjusting the behavior
# of this program to your
# liking

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
