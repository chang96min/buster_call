FROM amazoncorretto:17-alpine-jdk

LABEL maintainer="LEE CHANG MIN"
LABEL version="1.0.0"
LABEL description="지도(GIS)를 활용한 맛집 플랫폼(mini SNS)"

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]