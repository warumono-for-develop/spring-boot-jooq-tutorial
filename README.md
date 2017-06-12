# Spring Boot with JOOQ Tutorial
**An tutorial application using Spring Boot as REST API with JOOQ back-end.**

More details about the codes, please read the online **[Spring Boot](https://projects.spring.io/spring-boot).**

Requirements
------
Running in
+ [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.8 or newer
+ [Spring Boot](https://github.com/spring-projects/spring-boot) 1.5.2.RELEASE or newer
+ [jOOQ](https://www.jooq.org) 3.9.2 or newer
+ [Gradle](https://github.com/gradle/gradle) 3.4.1 or newer
+ [Lombok](https://projectlombok.org)
+ [H2](http://www.h2database.com/html/main.html)

Optional
------
+ YAML
+ Logback

Dependencies
------
+ [org.springframework.boot:spring-boot-starter-jooq](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jooq)
+ [org.springframework.boot:spring-boot-starter-security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
+ [org.jooq:jooq-codegen:3.9.2](https://mvnrepository.com/artifact/org.jooq/jooq-codegen)
+ [org.springframework.boot:spring-boot-devtools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
+ [com.h2database:h2](https://mvnrepository.com/artifact/com.h2database/h2)

Latest Update
------
+ 1.0 (Apr 20, 2017)

How to Run
------
+ Clone [this Git repository](https://github.com/warumono-for-develop/spring-boot-jooq-tutorial)
+ Generate Java code from your database
```command
$ ./gradle clean build
```
+ Build the project gradle build
+ Run the application **./gradlew bootRun**
```command
$ ./gradle bootRun
```

Check Java code with Database
------
**schema file**
[schema.sql](https://github.com/warumono-for-develop/spring-boot-jooq-tutorial/blob/master/SpringBootJooqTutorial/src/main/resources/schema.sql)
+ connect database
```url
http://localhost:8080/h2-console
```

**gradle file**
[build.gradle](https://github.com/warumono-for-develop/spring-boot-jooq-tutorial/blob/master/SpringBootJooqTutorial/build.gradle)
+ target packages
```java
def xml = new groovy.xml.MarkupBuilder(writer).configuration('xmlns': 'http://www.jooq.org/xsd/jooq-codegen-3.9.2.xsd') {
	...
	generator() {
		...
		target() {
			packageName('com.warumono.databases') // <----- base package path
			directory('src/main/java')            // <----- target directory path
		}
	}
}
```

API
------
#### Configuration
By default Spring Boot applications run on port **9090**.
But may vary depending on what ports are in use on your machine (check the terminal after entering the ./gradlew bootRun command).
If you require to change which port the application runs on by default, add the following to:

#### application.yml
```yml
server:
    port: 8080 # --> change other port via. 9090
```

Author
------
**warumono** - <warumono.for.develop@gmail.com>

License
------
**spring-boot-jooq-tutorial** is available under the Apache license. See the LICENSE file for more info.
