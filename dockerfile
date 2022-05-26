FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]