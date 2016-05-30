hadoop fs -rm -r output
hadoop fs -rm -r input
hadoop fs -mkdir input
hadoop fs -copyFromLocal input/* input
hadoop jar target/inverted-index-1.0-SNAPSHOT.jar input output
clear
hadoop fs -cat output/*
