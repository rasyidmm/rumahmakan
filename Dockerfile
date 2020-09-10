FROM openjdk:8
ADD target/RumahMakan-0.0.1-SNAPSHOT.jar RumahMakan-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","RumahMakan-0.0.1-SNAPSHOT.jar"]
