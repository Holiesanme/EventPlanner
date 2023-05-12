# SOA

To build the backend applications:
Maven clean install all the modules
docker build -t weather
docker build -t employee
docker build -t quotes
docker build -t quotesrating


Run inside /eventmanagerapp to build docker images
docker build -f Dockerfilemfe1 -t mfe1 .
docker build -f Dockerfilemfe2 -t mfe2 .
docker build -f Dockerfileshell -t shell .


To run docker containers:
docker compose up
