Command to  build docker image:
- docker build -t userapi  .

you can either pull from docker hub (https://hub.docker.com/r/metboz/userapi) ;
- docker pull metboz/userapi

command to run the image:
docker run  -p 5000:5000   metboz/userapi