# From https://vuejs.org/v2/cookbook/dockerize-vuejs-app.html
# Build: docker build -t vuejs-cookbook/dockerize-vuejs-app .
# Run:   docker run -it -p 7080:7080 --rm --name dockerize-vuejs-app-1 vuejs-cookbook/dockerize-vuejs-app

FROM node:lts-alpine

RUN npm install -g http-server

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 7080
CMD [ "http-server", "-p 7080", "dist" ]

# FIXME: after running and killing, app becomes available on port 8080
