# Portable dbreports project
Portable приложение для работы с базой данных и сохранения отчетов в excel.

Планируемый стек технологий:
- jdk1.8.0_231
- sqlite (база данных)
- apache poi (работа с excel)
- JavaFX (графический интерфейс)

Структура portable приложения:  
* /dbreports_portable
  + /jre1.8.0_231 (добавляется вручную)
  + /app  
    + /lib (библиотеки из зависимостей)
    + dbreports.jar
  + /workspace
    + /sqlite/
      + db.sqlite
    + /excel
      + *.xlsx
    + /backup
      + *.sqlite
  + /resources
    + config.properties
  + dbreports_run.bat
  
Использование:
1) собрать проект при помощи maven: clean -> install, собирается структура проекта в директории /target/dbreports_portable/
2) добавить /jre1.8.0_231 в /target/dbreports_portable/
3) запаковать /target/dbreports_portable/ в дистрибутив для передачи.