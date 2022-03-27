# A project demonstrating load balancing, e.g. nginx load balancing two
# spring boot applications (deployed via Docker).
#
# Credit: Khanh Nguyen https://huongdanjava.com/deploy-load-balancer-application-using-nginx-with-docker.html
#
# How to run:

#docker build -t nginx:0.0.1 .
mvn -f ctrler clean package -DskipTests
npm --prefix vue-app install
docker-compose up

# Then try:
#   curl http://localhost/hi
