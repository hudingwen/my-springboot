FROM openjdk:8

COPY target/springboot-0.0.1-SNAPSHOT.jar /app.jar

#CMD ["$myPars"]
#
#EXPOSE 8081
#
#ENTRYPOINT ["java","-jar","/app.jar"]



ENTRYPOINT ["sh","-c","java -jar /app.jar $myPars"]