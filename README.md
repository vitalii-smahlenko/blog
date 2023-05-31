<p align="center">
<img src="images/blog.jpg"width="500" height="400">
<p>

Project description
----

### *This is a simple blog application written in Java using Spring Boot and MongoDB. All CRUD operations are implemented in application.*

## User features in this application :

- Get a list of all articles, sorted from new to old
- Only registered users can create, like, dislike or delete articles.
- One user can like or dislike an article once.
- Only administrator can add roles to users.

## For easy testing, you can use the following instruction

- Registering a new user.
    - Send a POST request with a JSON object (example {"username": "Vitalii", "password": "1234"})
      to the URL http://localhost:8080/register
- Login a user
    - Send a POST request with a JSON object (example {"username": "Vitalii", "password": "1234"})
      to the URL http://localhost:8080/login

**To make one of the following requests, you need to log in**

- Create a article
    - Send a POST request with a JSON object ( example {"text": "Type your article here"}) to the
      URL http://localhost:8080/articles/create?userId=3&text=Hellow World!
- Update a article
    - Send a PUT request containing articleId and text to the
      URL http://localhost:8080/articles/update?articleId= &text= <br/>
- Like or dislike the article
    - Like, send a PUT request containing articleId and userId to the
      URL http://localhost:8080/articles/like?articleId= &userId= <br/>
    - Dislike, send a PUT request containing articleId and userId to the
      URL http://localhost:8080/articles/dislike?articleId= &userId= <br/>
- Get a list of all article, sorted from new to old.
    - Send a GET request to the URL http://localhost:8080/articles/all-article-by-id-desc
- Get a list of all article by username
    - Send a Get request to the
      URL http://localhost:8080/articles/get-article-by-user-name?username=Vitalii <br/>
- Delete the article
    - Send a DELETE request containing articleId to the URL http://localhost:8080/article/delete?noteId=

**To send POST requests, I used Postman. (Content-Type: application/json)**

- When the application starts for the first time, an administrator will be created (username: admin,
  password: admin)
    - The administrator can add roles to users, send a POST request containing the id and role to
      the URL http://localhost:8080/users/add-role-to-user?userId= &role=ADMIN

## Technologies

- Java 11.0.12
- Apache Maven 3.8.1
- Spring boot 2.5.9
- Spring Security
- MongoDB 6.6
- Lombok
- MapStruct
- Swagger http://localhost:8080/swagger-ui.html
