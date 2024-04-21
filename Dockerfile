#start with a base command setting up the java environment
FROM openjdk:17-jdk-slim

#maintainer mame
MAINTAINER gatrix


#adding application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar


#executing the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
