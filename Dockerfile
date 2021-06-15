FROM ghcr.io/graalvm/graalvm-ce:latest
ADD . /build
WORKDIR /build
RUN \
microdnf install -y unzip zip; \
curl -s "https://get.sdkman.io" | bash; \
/bin/bash -c "source /root/.sdkman/bin/sdkman-init.sh; sdk install maven; gu install native-image;"
RUN /bin/bash -c "source /root/.sdkman/bin/sdkman-init.sh; mvn --version"
RUN native-image --version
RUN /bin/bash -c "source /root/.sdkman/bin/sdkman-init.sh; mvn -Pnative-image clean package"

FROM oraclelinux:7-slim
COPY --from=0 "build/target/wte" wte
CMD [ "sh", "-c", "./wte -Dserver.port=$PORT" ]