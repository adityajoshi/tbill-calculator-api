# # Start with a base image that has Java 17 installed.
# FROM eclipse-temurin:17-jdk-jammy
#
# # Set the working directory in the container
# WORKDIR /app
#
# # Copy the Gradle files
# COPY build.gradle settings.gradle /app/
#
# COPY gradlew /app/
# COPY gradle /app/gradle
#
# # Copy the source code
# COPY src /app/src
#
# # Build the application
# RUN chmod +x /app/gradlew && \
#     /app/gradlew build
#
# # Expose the port that the Spring Boot app will run on
# EXPOSE 8080
#
# # Command to run the application
# CMD ["/app/gradlew", "bootRun"]

# Above is a traditional approach I know of

# Below is a modular approach where we create a builder image using jdk, gradle
# But you don't need those tools to run your app so separate image for runtime which would be slim in size.
# You can set a name to an image using 'as' keyword. It's useful when you want to fetch content out of it.

FROM docker.io/library/gradle:jdk17-jammy as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM docker.io/library/eclipse-temurin:17-jre-alpine
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar
WORKDIR /app
# RUN ls -lrt
CMD ["java", "-jar", "app.jar"]
