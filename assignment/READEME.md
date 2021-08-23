# User Details Project with Basic Spring Security

### _***Build and Deploy the Project***_

This is a Spring Boot project based on maven, so can 
deploy it by simply using the main class: `AssignmentApplication.java`

Once deployed , you can access the app at: 
https://localhost:8080

As it is configured with basic spring security, so
please use the following credential for **authorization**.

**username: nischal,**

**password: nischal123**

After configured it ,

1 ) if you want to **add** the user, use the below api with _**UserDao**_

url : https://localhost:8080/user/add

2 ) if you want to **fetch** the user

url : https://localhost:8080/user/get/{username}

3 ) if you want to **update** the user, use the below api with _**UserDao**_

url : https://localhost:8080/user/update

4 ) if you want to **delete** the user

url : https://localhost:8080/user/delete/{username}

###### UserDao has following properties:

1) userName

2) password

3) status


## **_Set up Database_**

By default, the project is configured to use the embedded **H2** database.

After **authorization**, to view database use the following api:
https://localhost:8080/h2-console
