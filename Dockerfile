FROM hseeberger/scala-sbt

WORKDIR /mastermind
ADD . /mastermind

CMD ["sbt", "run"]