# Tech Test 

Command line JAVA application with database access

## Features ##

* Persist a new server data on database
* Edit a server data
* Delete a server data from database
* List all persisted servers
* Count servers persisted
* Import a xml with server data and persist
* H2 Memory database for Dev profile
* Junit Report

## Getting Help ##

After launch the application, text "help" to see all the available commands

# How to Use ##

Download the jar from the project root and launch it using one of the profiles.

*Prod:*
- Using PostgresSQL9.4 as database server.
- A data.sql with the database schema is providade on resources folder.
- A localhost server is required with the follow credentials
```xml
url: localhost:5432/server
username: postgres
password: postgres
```
Run command:
```java
 java -jar -Dspring.profiles.active=prod server-data-1.0.0.jar
```
*Dev:*
- H2 memory database as database server.
- No extra configuration is required
- The database and table are created automatically

Run command:
```java
 java -jar -Dspring.profiles.active=dev server-data-1.0.0.jar
```

## Test Report ##

Compile and build the project
```java
 mvn clean install
```

A Junit test report will be created at /report folder on root project

## Commands Help ##

*add*: Persist a new server on database:

Parameters:
- ServerName
- Server Description

```java
 add myServerName "my Server Description"
```

*update*: Update an existing server

Parameters:
- Server Id
- New Server Name
- New Server Description (Optional)
```java
 updated serverID newServerName "new Server Description"
```

*delete*: Delete a persisted server

Parameters:
- Server Id
```java
 delete serverID
```

*count*: Count persisted servers
```java
 count
```

*list*: List all servers
```java
 list
```

*xml*: Persist a server data provided by xml file
- A xml schema can be found on root folder (*server_definition.xml*)

Parameters:
- absolutePath: xml file path *use Forward slash*
```java
xml /home/user/server_data.xml
```

```java
C:/server_data.xml
```

*help*: Display Commands
```java
help
```

# Tech Stack:

- Java 8
- Springboot 2.1.4 with tomcat embedded
- SpringShell 2.0.1 for command line
- SpringData JPA 2.1.6
- Junit 4.12
- H2 database 2.1.4.199
- PostgresSQL 9.4.1
- Maven
- Github
- Intellij IDEA