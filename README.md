# LatticeAssignment

1). Technology used
---------------------------------------
For this project i have used Spring boot and for database operation's i have used Hibernate(implementation of JPA).
For Authorization and authenticate requests i have user JWT(JSON WEB TOKENS).
For validations i have used javax.validation dependency.
For API documentations i have used swagger.

2). Swagger - 
----------------------------------------
Swagger is used to describe the API's, swagger is easily adjustable, it can be successfully used for API testing and bug fixing.
Another important point is that the same documentation can be used for accelerating various API-dependent processes.
It as a blueprint for a house. You can use whatever building materials you like, but you can't step outside the parameters of the blueprint.
It save time and avoid error when writting the code.

3). JWT -
----------------------------------------
The main reason to use jwt is to provide sevurity.
JWT is secure Because JWTs are stateless, when a server-side application receives a JWT,
it can validate it using only the “secret key” that was used to create it
— thereby avoiding the performance penalty of talking to a database or cache on the backend, which adds latency to each request.

4). How to execute the project -
-----------------------------------------
- If you want to execute the project so you just need to download the zip file
-  After that you can extract that zip file .
- Open your STS IDE and import that project into your IDE.
- When you successfully import that project just click on the project and run that project.
- When your project is on running condition just go to your type http://localhost:8081/swagger-ui.html#/ in your browser, this will open the api 
documentation for you.
- fire the /savepatient request and give the necessary details (remove jwt from request body).
- after successfull attempt ypu will get JWT Token as a response copy that token and that Token into swagger Authentication header whth the bearer.
- Now you can easily check the API's and test them.


