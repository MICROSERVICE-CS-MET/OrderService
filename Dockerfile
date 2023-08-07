# 1. Build stage
FROM gradle:8.1.1-jdk17 AS build

WORKDIR /order_service

# Copy the rest of the source code
COPY . .

# Build the application
RUN gradle build --no-daemon

# 2. Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /order_service

COPY --from=build /order_service/build/libs/order-service-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]
