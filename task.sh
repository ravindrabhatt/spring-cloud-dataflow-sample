app register --name batch-job --type task --uri maven://org.kun:spring-cloud-task:jar:0.0.1-SNAPSHOT
task create task-sample --definition batch-job
task launch task-sample
