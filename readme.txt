Framework Used - Spring Boot, Database Used - MongoDB, Deployed on Heroku as a containerized application

Steps to run and what every command means:

1. Move to the directory where the project is downloaded (For example : cd ~/Downloads/images-collector)
2. Run the docker-compose.yml file using command  - docker-compose up (This command creates containers for all the services, databases defined in docker-compose.yml)
3. Hit the url - localhost:8080/ in the browser to see the output, a random image from https://picsum.photos will be displayed
On hitting the url with /:id like - localhost:8080/60, an image with id 60 on https://picsum.photos will be displayed

Note : The image for container in which spring boot app is running is created using the Dockerfile and the image for mongo database is pulled from the docker hub

Additional Commands and steps:

3. Command to see which containers are running this command in a separate tab of terminal - docker container ls (Here you will find the 2 containers running that were created using docker compose file)
4. In order to enter into any container run the command in terminal - docker exec -it <container_id> /bin/sh  (the container id can be fetched from step 3)
5. On entering into the spring boot container, one can see the app.jar in root directory which is the jar of the spring boot application
6. On entering into mongodb database container, one can see the data saved in the database by launching mongo shell and then going on to the specific database and collection name


Some information:

The image for container in which spring boot app is running is created using the Dockerfile and the image for mongo database is pulled from the docker hub

