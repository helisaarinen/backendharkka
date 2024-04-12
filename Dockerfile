## Based on https://community.render.com/t/3232

# Build stage
# Use an official Maven image as the base image
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
# Copy the project files and the pom.xml to the container
COPY src /home/app/src
COPY pom.xml /home/app
# Build the application using Maven
RUN mvn -f /home/app/pom.xml clean package
# Package stage
# Use an official Maven image as the base image
FROM eclipse-temurin:17-jre-focal
# Copy the built JAR file from the previous stage to the container
COPY --from=build /home/app/target/Turnaus-0.0.1-SNAPSHOT.jar /usr/local/lib/pkg.jar
EXPOSE 8080
# Set environment variables for PostgreSQL connection
ENV SPRING_DATASOURCE_URL=postgres://postgres:Koulujuttu2024!@postgres:5432/Turnaus
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=Koulujuttu2024!
# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/usr/local/lib/pkg.jar"]
