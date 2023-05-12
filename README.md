# Event Manager Application

To build the backend applications:

Maven clean install all the modules
docker build -t room
docker build -t participants


Run inside /eventmanagerapp to build docker images
docker build -f Dockerfilemfe1 -t mfe1 .
docker build -f Dockerfilemfe2 -t mfe2 .
docker build -f Dockerfileshell -t shell .


To run docker containers:
docker compose up
