@echo off
echo Iniciando o backend Spring Boot...
cd /d "%~dp0"
mvn clean compile
mvn spring-boot:run
