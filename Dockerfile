FROM gradle:7.3-jdk17 as build

RUN apt-get update

RUN apt-get install git

RUN git clone https://daniil-lab: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@github.com/daniil-lab/bot-parser.git wp

WORKDIR wp

RUN #gradle clean build

FROM openjdk:17-alpine

COPY --from=build /home/gradle/wp/out/artifacts/telegram_parser_main_jar/telegram-parser.main.jar .

#COPY ./images ./images

EXPOSE 8080

ENTRYPOINT java -jar telegram-parser.main.jar
