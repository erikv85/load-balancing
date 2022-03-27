# From https://vuejs.org/v2/cookbook/dockerize-vuejs-app.html
# Build: docker build -t vuejs-cookbook/dockerize-vuejs-app .
# Run:   docker run -it -p 7080:7080 --rm --name dockerize-vuejs-app-1 vuejs-cookbook/dockerize-vuejs-app

#FROM node:lts-alpine
FROM ubuntu:20.04
RUN yes | unminimize

#RUN apk update && apk add bash
RUN apt upgrade && apt update -y
RUN apt install -y curl
#RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
#RUN wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
#ENV NVM_DIR="$([ -z "${XDG_CONFIG_HOME}" ] && printf %s "${HOME}/.nvm" || printf %s "${XDG_CONFIG_HOME}/nvm")"
#ENV NVM_DIR="$[ -z \"${XDG_CONFIG_HOME-}\" ]"
#RUN echo "NVM_DIR: "$NVM_DIR
#RUN [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
#RUN nvm use 17
RUN curl -sL https://deb.nodesource.com/setup_16.x | bash -
RUN apt install -y nodejs
RUN node --version
#RUN apt install -y npm
RUN npm --version

WORKDIR /app

COPY package*.json ./

RUN npm config set fetch-retry-mintimeout 2000000
RUN npm config set fetch-retry-maxtimeout 12000000
RUN npm install -g http-server
#RUN npm install chokidar@2.1.8
#RUN npm install --loglevel verbose

COPY . .

RUN npm run build

EXPOSE 7080
CMD [ "http-server", "-p 7080", "dist" ]

# FIXME: after running and killing, app becomes available on port 8080
