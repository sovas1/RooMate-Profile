FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD ./target/pl.roomate.profile-1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]