FROM openjdk:8-jre
MAINTAINER ArvinXY <arvinjunior@163.com>

ENTRYPOINT ["java","-jar","-Xmx128m","-Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5555","/opt/rina-songlist.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/rina-songlist.jar