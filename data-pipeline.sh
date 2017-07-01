app register --name http-source --type source --uri maven://org.kun:spring-cloud-data-flow-source:jar:0.0.1-SNAPSHOT

app register --name transform-processor --type processor --uri maven://org.kun:spring-cloud-data-flow-processor:jar:0.0.1-SNAPSHOT

app register --name logging-sink --type sink --uri maven://org.kun:spring-cloud-data-flow-sink:jar:0.0.1-SNAPSHOT

stream create --name transform --definition 'http-source --server.port=8000 | transform-processor --expression=payload.toUpperCase() | logging-sink'

stream deploy --name transform

# curl -X POST http://localhost:8000/kun  -H 'content-type: text/plain'  -d 'make this uppercase'
