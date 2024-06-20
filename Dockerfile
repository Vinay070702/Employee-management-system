FROM openjdk:12
ADD target/EMS-App-0.0.1-SNAPSHOT.jar EMS-App-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/EMS-App-0.0.1-SNAPSHOT.jar"]