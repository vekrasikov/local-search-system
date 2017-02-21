## Build
mvn clean package
## Run Mongo in Docker container
docker run --name search-mongo -p 27017:27017 -d mongo
## Run Search System
java -jar /path/to/compiled/jar