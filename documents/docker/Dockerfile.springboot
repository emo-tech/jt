FROM java:8-alpine
RUN mkdir -p /tmp
COPY ./jt-springboot-basic-1.0.0.jar /tmp/app.jar
EXPOSE 5001
ENTRYPOINT java -jar /tmp/app.jar