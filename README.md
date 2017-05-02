## Configure
By default all services run on *localhost* on the following ports:

- configuration     8888
- discovery         8761 (8762)
- ui               8787
- security          9007
- user              8333
- api-gateway       9000

1. Services read configuration from configuration service.
To change ports and other configurations locate the .yml files from configuration for each service.

2. Note: Start configuration service with dev, native profile.

## Run on dev env
1. Commend spring-boot-starter-tomcat from main pom to build jars and run spring boot services on embedded tomcat.
2. Build project from root directory with main pom.
3. From Eclipse Boot Dashboard or command line - start the services in the following order:

- java -jar services/configuration/target/configuration-0.0.1-SNAPSHOT.jar --spring.profiles.active=native,dev
- java -jar services/discovery/target/discovery-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
- java -jar services/security/target/security-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
- java -jar services/ui/target/ui-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
- java -jar services/user/target/user-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
- java -jar services/api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

