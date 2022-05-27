FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/GesF-1.0.jar GesF-1.0
RUN addgroup -S spring && adduser -S spring -G spring
ENTRYPOINT ["java","-jar","app:app/lib/*","gesformation_app"]