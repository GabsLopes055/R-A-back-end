# Usa a imagem oficial do Maven para compilar o projeto
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto para dentro do contêiner
COPY . .

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# Usa uma imagem leve do Java para rodar a aplicação
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR compilado da etapa anterior
COPY --from=builder /app/target/RA-BackEnd-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]