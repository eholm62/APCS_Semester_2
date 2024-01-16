for file_name in $1/*.java
do java InsertPackage $1 $file_name
done  
