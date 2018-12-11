****Video Store Rest Api****

REST API built using spring boot and postgresql that uses specific end points.

****Requirements****

1. Use Spring Boot to create the project.
2. Define from 2 to 3 resources.
3. Handle CRUD operations on these resources.
4. Between two of available resources, relationship has to be defined.
5. You HAVE to use H2 or PostgreSQL database.
6. Keep separate concerns of your app - controller, service, repository. 
7. Logging of every CRUD operation and exception to a text file using log4j.
8. Data should be safe deleted - archived instead of physically deleted. Users should not see archived data but the data should be present in the database.
9. Application should send automatically emails with error details.

****Getting started****

1. Download the code

    git clone https://github.com/CodecoolKRK20171/java-ee-rest-api-crud_summer.git
    
2. Run VideoStoreRestApiApplication

3. Fill in database using data.sql file in src/main/resources/sql

**End points**

Director page

    "/store/directors" = Get method: displays all directors
    "/store/directors" = Delete method: delate all director
    "/store/directors" = Post method: add direcotr
    "/store/directors/{id}/movies" Get method: display movies created by chosen director
    "/store/directors/{id}" = Get method: displays chosen director
    "/store/directors/{id}" = Delete method: delete chosen director
    "/store/directors/{id}" = Put method: update information about chosen director

Admin page:

    "/admin/archived/movies" - Displaying all archived movies
    
Genre page

    "/store/genre" = Get method: displays all genres
    "/store/genre" = Post method: add genre
    "/store/genre/{id}" = Get method: displays choosen genre
    "/store/genre/{id}" =  Put method: update information about chosen genre
    "/store/genre/{id}/movies" = Get method: display movies by choosen genre
    
Movie page

    "/store/movies" = Get method: displays all movies
    "/store/movies" = Delete method: delate all movies
    "/store/movies" = Post method: add movie
    "/store/movies/{id}" = Get method: displays chosen movie
    "/store/movies/{id}" = Delete method: delete chosen movie
    "/store/movies/{id}" = Put method: update information about chosen movie
    
****Built With****

1.	Maven - Dependency Management
2.	Spring Boot
3.	PostgresSQL

****Authors****
Damian Targosz,
Adam Szmidt,
Tomek Pieczkowski


****More info****

Project made for Codecool programming course.
