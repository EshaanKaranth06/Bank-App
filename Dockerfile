FROM openjdk:21-jdk-slim AS build

# Install Maven dependencies
RUN apt-get update && apt-get install -y wget curl gnupg2

# Download and install Maven
RUN wget https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz \
    && tar -xvf apache-maven-3.8.6-bin.tar.gz \
    && mv apache-maven-3.8.6 /opt/maven

# Set Maven environment variables
ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

# Copy the project files and run Maven
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/bankapp-0.0.1-SNAPSHOT.jar bankapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bankapp.jar"]
