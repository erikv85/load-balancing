# A project demonstrating load balancing, e.g. nginx load balancing two
# spring boot applications (deployed via Docker).
#
# Credit: Khanh Nguyen https://huongdanjava.com/deploy-load-balancer-application-using-nginx-with-docker.html
#
# How to run:

docker build -t nginx:0.0.1 .
(cd ctrler && mvn clean package -DskipTests && docker build -t spring-boot-docker-compose .)
(cd vue-app && docker build -t dockerize-vuejs-app .)
docker-compose up

# Then try:
#   curl http://localhost/hi
