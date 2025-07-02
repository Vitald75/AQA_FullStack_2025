# Описание проекта
### Этот проект содержит автоматизированные тесты для UI, web-приложения https://opensource-demo.orangehrmlive.com, реализованные с использованием Java, Maven, JUnit и Rest-Assured.

## Используемые технологии
- **Java 21:** Язык программирования.
- **Maven:** Система сборки и управления зависимостями.
- **Selenium WebDriver:** Фреймворк для взаимодействия с браузером. 
- **JUnit:** Фреймворк для написания тестов.
- **Rest-Assured:** Библиотека для тестирования REST API.

## Структура проекта
- src/main/java: Содержит исходный код вашего приложения (если есть).
- src/test/java: Содержит тестовые классы. Обычно, тесты находятся в поддиректории tests.
- src/test/java/resources/conf.properties: Содержит базовый URL, креды.

## Настройка проекта

1.  **Установка Maven:** Убедитесь, что у вас установлен Maven. Если нет, скачайте и установите его с [официального сайта](https://maven.apache.org/download.cgi).
2.  **Клонирование репозитория:**  Клонируйте данный репозиторий на свой компьютер.
3.  **Импорт проекта в IDE:**  Импортируйте проект в вашу любимую IDE (например, IntelliJ IDEA, Eclipse).
4.  **Настройка зависимостей:** Проект использует Maven для управления зависимостями. Все необходимые библиотеки (JUnit, Rest-Assured) будут загружены автоматически при первом запуске тестов или при сборке проекта.

## Запуск тестов через командную строку
Для запуска тестов выполнить следующие команды в корневой директории проекта 
### Запуск всех тестов
mvn clean test
### Запуск смоук тестов
mvn clean test -Dgroups=smoke
### Запуск расширенных тестов
mvn clean test -Dgroups=extended
### Запуск тестов по страницам
### Страница логина
mvn clean test -Dgroups=login
### Выход из системы
mvn clean test -Dgroups=logout
### Страница Dashboard
mvn clean test -Dgroups=dashboard
### Страница Job Titles
mvn clean test -Dgroups=jobtitles
### Страница Leave
mvn clean test -Dgroups=leave
### Страница AddRecruitment
mvn clean test -Dgroups=recruitment
### Страница PIM
mvn clean test -Dgroups=employee

