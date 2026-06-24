# Step 1: Use an official lightweight OpenJDK image for building
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy the project files
COPY . .

# Fix potential permission issues with the Gradle execution wrapper
RUN chmod +x gradlew

# Build the production jar application file
RUN ./gradlew bootJar --no-daemon

# Step 2: Create the final lightweight runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app
EXPOSE 8080

# Copy the compiled jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
