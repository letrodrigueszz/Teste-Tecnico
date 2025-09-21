@echo off
echo Iniciando o frontend Angular...
cd /d "%~dp0\frontend"
npm install
ng serve --host 0.0.0.0 --port 4200
