# $1 given in ~/.bashrc should be the path 
# to the the base directory of the github repo    
alias java="java -cp .:$1/StdLib"
alias javac="javac -cp .:$1/StdLib" 
alias runbashrc=". ~/.bashrc"