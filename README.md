# seckill - Distributed Application for Purchasing Merchandise
* Developed back-end with Spring Boot to avoid overselling and redundant purchase during intensive activity in seconds.
* Implemented the CRUD interface at DAO tier with Mybatis.
* Integrating log4j and Spring AOP to intercept each http request at SpringMVC controller tier.
* ...

## Tech: SpringMVC, Spring, Mybatis  
* Flexible framework to develop application
* Wide usage
 
### MyBatis
* DAO lay development
* Integration wiht Spring

### Spring
* Spring IOC and Service integration
* SpringMVC

### Environment
> OS： Windows 7  
IDE： IntelliJ  
JDK： JDK 1.8  
Database： MySQL 5.6  
Tool： Maven


## DAO Development  
> 1. Generate Maven and Construct Dependence (pom.xml)  
> 2. Develop Database with MySQL  
> * Build entity class and DAO interface
> 3. Implement DAO interface with MyBatis
> * Build XML and mapper
> 4. Spring and MyBatis Integration
> * Build spring-dao.xml
> 5. DAO Unit Test
