# **API-HEROKU-TEST**

**API-HEROKU-TEST** is a simple application build using Spring Boot.

This API is using H2 DataBase and Heroku as a Cloud Server.


## **General info**

I started this litle project as a way to practice creating APIs with Java and Spring Boot Framework. The purpose of this application is to show a list of clients with all the basic functionalities in the **persistence layer or database** (*CRUD*).


## **Demo**

You can run this application by using the Heroku Cloud link below:

https://agustrocha-first-api-test.herokuapp.com/


## **Technologies**

- **Html**
- **Java**
- **Spring Boot**



## **Code**
The application follows a structure model widely used today. Spring Boot is capable of creating **controllers** (*controller folder*) that allow us, through the use of **services** (*model.service folder*), to make requests to the **repository** (*model.dao* folder), and this in turn makes use of the **model** (*model.entity* folder) that accesses the databases as an entity, which returns a result.

The repository uses **EntityManager** which is an *interface* that is used to create and remove persistent entity instances, to find entities by their primary key, and to query over entities.

Thanks to this interface I've been able to perform all the CRUD functions of the application.

## **Usage**

1. Just open up the link from [Demo](https://agustrocha-first-api-test.herokuapp.com/).
2. The first load maybe takes a few seconds to load since I'm using a free server from heroku, so be patient 🙃.


## **Status**

Project is: **_Completed._**

But it can also be greatly improved: 

- **TODO**
    - Adding tests
    - Adding style to the frontend
    - Improving API documentation
    - Dividing backend and frontend


## **Contact**

Created by [@agustrocha](https://www.linkedin.com/in/agust%C3%ADn-torres-02bbbb1a8/).
