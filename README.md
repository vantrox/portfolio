# Portfolio

This project has propose to show a portfolio to displays the profile image, name and a text description. And integrate API Twitter to show last 5 tweets.

## TOTAL PROJECT HOUR: 7 hours 

**WARNING**

* * Currently to request Tweets you need a level Basic into API * *

for demonstration purposes a fake list has been included to demonstrate how tweets work when it is not possible to connect with the API

###Prerequisites

```

JAVA JDK 11+
Navigator Chrome 115.0.5790.171+ or Edge 115.0.1901.203+
Netbeans 17+

```

###Steps to build the app

This project was developed in Netbeans IDE, however it can be compiled in any IDE with maven support
After construction, a .jar file will be generated that will have all the files needed to run the application.

```

- To use Tweets list configure api access into file **application.properties** in /src/main/resources/
Remember, currently you need a Basic access in the API to request tweets set the fields into file .properties:

```

twitter.clientID=YOUR_CLIENT_ID
twitter.clientSecret=YOUR_SECRET_ID
twitter.accessToken=YOUR_ACCESS_TOKEN
twitter.refreshToken=YOUR_REFRESH_TOKEN

```

- Set Database in application.properties, set the fields below into file .properties: (used database as requested, using **zemoga_challenge_db** and  **portfolio** table)

```

spring.datasource.url=jdbc:mysql://SERVER:PORT/DATABASE
spring.datasource.username=USERDB
spring.datasource.password=PASS_DB

```

SERVER - Your address server DB
PORT - Port to connect in the server DB
DATABASE - Database to get the tables
USERDB - User to access DB
PASS_DB - password to access DB

- To change profile ID, you need to change file **profile.js** in /src/main/resources/static/js/

- To access open your navigator the URL: http://localhost:8080/

```


###API REST

There are two endpoins

```

Request Method  GET
/portfolio/{id}

```

{id} - is the id profile in database

```

Request Method  PUT
Body content:
{
    "description":"new description",
    "imageUrl":"http://new.image.url",
    "fullName":"new Title"
}

```

description - Text about experience
imageUrl - A string url to set image 
fullname - Full name of the person

###Technologies

```

Maven (project)
Twitter API V2 2.0.3 (access tweets)
Springboot 2.7.14 (API RES and Front)
Thymleaf (front)
Ajax 1.10.2 (requests front API)
Mysql-connector-j 8.1.0 (connector DB)
Lombok 1.18.28 (Clean getters and setters)
Gson 2.10.1 (parse Json objects)
Apache Httpcomponents 4.5.14 (requests HTTP in code line)
AdminLTE 3.1.0 (front UI)

```

###Database test

‣ Table: portfolio
‣ Database: zemoga_challenge_db

###Unit Tests

- Test Get Portfolio
- Test Get Portfolio Nonexistent
- Test Put update