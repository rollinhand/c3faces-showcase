FROM tomee:8-jre-7.0.4-webprofile

LABEL maintainer="rollin.hand@gmx.de"
LABEL version="${version}"

# In maven/ the files as specified in the <assembly> section is stored
# and need to be added manually
ADD maven/${finalName}.war /usr/local/tomee/webapps/${finalName}.war

EXPOSE 8080

CMD ["catalina.sh", "run"]