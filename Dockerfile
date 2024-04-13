# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
