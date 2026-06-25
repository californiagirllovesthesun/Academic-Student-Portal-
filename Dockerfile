
# Step 1: Use an official lightweight OpenJDK image for building
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

# Step 2: Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy the jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar
# Expose the port
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]