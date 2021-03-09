FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrtb_bot
ENV BOT_TOKEN=1621646150:AAHxk2Q-dsXuEPatScA1CXgQljLINDIMTbY
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}","-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]