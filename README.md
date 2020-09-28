# securityHistory
Web-приложение "Ценные бумаги и их история"   
Функции:  
+ Импорт данных из xml файлов
+ Операции CRUD для ценных бумаг (при добавлении проверка поля  name)
+ Отображение данных из тегов (secid, regnumber, name, emitent_title, tradedate, numtrades, open, close) + сортировка и фильтрация

Приложение запускается с главной страници index.html  
JavaScript (запросы GET/POST) -> Java (Servlet) -> БД  
                              <-                <-

Использовалось:  
СУБД - PostgreSQL   
Сервер - Apache Tomcat 9  
Библиотеки: 
+ postgresql - для работы с PostgreSQL
+ javax.servlet - для работы с Servlet
+ jackson - для работы с JSON
+ jQuery
