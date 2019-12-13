FROM java:8u231

ADD ./target/eureka-server.jar /

ENV JAVA_OPTS="-Xms128m -Xmx512m"
VOLUME /tmp
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /eureka-server.jar"]