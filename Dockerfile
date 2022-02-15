FROM gradle:7.3-jdk17 as build

RUN apt-get update

RUN apt-get install git

RUN git clone https://daniil-lab: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@github.com/daniil-lab/bot-parser.git wp

WORKDIR wp

RUN #gradle clean build

FROM openjdk:17-alpine

COPY --from=build /home/gradle/wp/out/artifacts/telegram_parser_main_jar/telegram-parser.main.jar .
COPY --from=build /home/gradle/wp/src/main/resources/hibernate.cfg.xml .

#COPY ./images ./images

RUN curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

RUN add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

EXPOSE 3001

ENTRYPOINT java -jar telegram-parser.main.jar
