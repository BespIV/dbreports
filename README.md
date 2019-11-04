# Portable dbreports project
Portable приложение для работы с базой данных и сохранения отчетов в excel.

Планируемый стек технологий:
- jdk1.8.0_231
- sqlite (база данных)
- apache poi (работа с excel)
- JavaFX (графический интерфейс)

Структура portable приложения:  
* /Project  
  + /jre1.8.0_231
  + /app  
    + dbreports.jar
  + /workspace
    + /sqlite/
      + db.sqlite
    + /reports
      + *.xlsx
    + /backup
      + *.sqlite
  + /resources
    + config.properties
  + run_jar.bat
  
Использование:
1) в настройках IntelliJ IDEA "Project Structure" - "Artifacts" подключаются библиотеки и драйвера; 
2) создается артефакт dbreports.jar "Build" - "Build artifacts...";
3) dbreports.jar копируется в каталог /app;
4) config.properties копируется в каталог /resources;
5) сформированная структура архивируется (.zip) для дальнейшего развертывания.