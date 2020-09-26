FROM azul/zulu-openjdk-alpine:11-jre as builder
WORKDIR application
ADD maven/${project.build.finalName}.jar ${project.build.finalName}.jar
RUN java -Djarmode=layertools -jar ${project.build.finalName}.jar extract

FROM azul/zulu-openjdk-alpine:11-jre
LABEL PROJECT_NAME=${project.artifactId} VERSION=${project.version}
EXPOSE 8080
WORKDIR application
COPY --from=builder /application/dependencies/ ./
COPY --from=builder /application/spring-boot-loader/ ./
COPY --from=builder /application/snapshot-dependencies/ ./
COPY --from=builder /application/application/ ./
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","org.springframework.boot.loader.JarLauncher"]