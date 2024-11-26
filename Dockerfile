# Dockerfile
# Step 1: Specify the base image
FROM openjdk:22-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the application JAR file to the container
COPY target/*.jar app.jar

# Step 4: Expose the port the service will run on
EXPOSE 8080

# Step 5: Run the application with environment variables passed in
ENTRYPOINT ["java", "-jar", "app.jar"]