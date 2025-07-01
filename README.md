Запуск тестов через командную строку
Запуск всех тестов
mvn clean test

Запуск смок тестов по тегу
mvn clean test -Dgroups=smoke

Запуск Extended тестов по тегу
mvn clean test -Dgroups=extended


Запуск тестов по страницам

Страница логина
mvn clean test -Dgroups=login

Логаут
mvn clean test -Dgroups=logout

Страница Dashboard
mvn clean test -Dgroups=dashboard

Страница Job Titles
mvn clean test -Dgroups=jobtitles

Страница Leave
mvn clean test -Dgroups=leave

Страница AddRecruitment
mvn clean test -Dgroups=recruitment

Страница PIM
Форма Add employee
mvn clean test -Dgroups=employee

