# ISBN Validation

###About
This application contains code which will validate 10 and 13 digit ISBN numbers. 
It also provides a rest endpoint for which a list ISBNs can be sent from a UI 
and return their validities. There is a Swagger page which will be accessible
when the application is running that can be found at

```http://localhost:8080/swagger-ui.html```

###Steps
Clone repository: ```git clone https://github.com/pwez/isbn-validation.git```

Go to directory: ```cd isbn-validation```

Build & run: ```mvn clean install spring-boot:run```