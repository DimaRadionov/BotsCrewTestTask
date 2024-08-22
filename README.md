# BotsCrew coding challenge

This Java application allows us store departments and their lectors. The lectors could work in more than one department. A lector could have one degree (assistant, associate professor, professor).

### Configuration

To run the application you have to modify application.properties file with your database url and credentials.
 ```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
 ```
Modify this piece of code.

### My solution

My solution is provided with some test data. All are written in CMDApplicationRunner file, in startingData function.
Application supports all 5 commands, which was written in the task, such as:
1. Who is head of department {department_name}
2. Show {department_name} statistics
3. Show the average salary for the department {department_name}
4. User Input: Show count of employee for {department_name}
5. Global search by {template}

### About architecture

I tried to implement and designed the solution as it will be deployed, that's why I tried to sort everything via packages and tried to follow OOP.

I want to say thanks to BotsCrew for providing this kind of task, which task I enjoyed to implement. 