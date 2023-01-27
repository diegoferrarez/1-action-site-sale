FROM openjdk:17-jdk-slim
WORKDIR /app
ENTRYPOINT ["java", "-jar", "action-site-sale.jar"]

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#RUN bash -c 'touch /credential.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/credential.jar"]