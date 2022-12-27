FROM openjdk:17-alpine3.14
#workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
ADD target/DockerSelenium.jar       DockerSelenium.jar
ADD target/DockerSelenium-tests.jar DockerSelenium-tests.jar
ADD target/libs                     libs

#ADD SUITES FILES
ADD testnj.xml                      testnj.xml
ADD search-module.xml               search-module.xml

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT java -cp DockerSelenium.jar:DockerSelenium-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=${HUB_HOST} org.testng.TestNG $MODULE
