# testTask
# Проект доделан, спасибо за доп время
1)

Java 1.7.0	

Postgres latest

login:postgres

password:postgres

mongoDB:latest

собран на gradle

использована liquibase для раскрытия БД ( постгре) и метод postConstruct (монго)


2)
все входные данные для контреллеров будуn в постман файле для двух CrudController'ов

в каждом из Controllers есть getById(ID),getByPhoneNumber(phoneNumber),updateById(ID),updateByPhoneNumber(phoneNumber),deleteById(ID),deleteByPhoneNumber(phoneNumber),getList(Filter) и  для тестов save()

все входные данные имеют тип Required

3)

3.1)скачиваем проект командой git clone https://github.com/qecstr/testTask.git

3.2)запускаем докер и активируем контейнеры в файле compose.yaml оба бд(в случае если при запуске проекта оно не запустися)

3.3)заходим в постман и импортируем для постгре testTask-postgreSql.postman_collection.json для монго testTask-MongoDB.postman_collection.json

3.4)видим результат

3.5)для теста запустить класс mongoDbControllerTest

3.6)увидить результат,удивиться(или претвориться что удивлены)
