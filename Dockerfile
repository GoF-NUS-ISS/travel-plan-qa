FROM alpine/git as gitclone
WORKDIR /app
RUN git clone https://akashdktyagi:f7898852fec02d26702c629e4283ef0a329892ec@github.com/GoF-NUS-ISS/travel-plan-qa.git

FROM maven:3.5-jdk-8-alpine as textexec
WORKDIR /app
COPY --from=gitclone /app/travel-plan-qa /app
ENTRYPOINT ["sh","-c"]
CMD ["mvn clean install"]
