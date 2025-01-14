# Use OpenJDK 21 as the base image
FROM openjdk:21

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy your project files into the container
COPY . .

# Default command (adjust if necessary)
CMD ["mvn", "clean", "install"]
