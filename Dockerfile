FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app-checkout.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app-checkout.jar"]