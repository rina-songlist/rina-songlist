FROM amazoncorretto:8
MAINTAINER ArvinXY <arvinjunior@163.com>

# 时区问题
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ENTRYPOINT ["java","-jar","-Xmx128m","/opt/rina-songlist.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/rina-songlist.jar