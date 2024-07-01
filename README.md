# I am doing a big refactoring of the code base and adding new features. I will move the repository anytime soon.
# Spring Store

A deployable e-commerce site for your business. **Under development**

## Getting Started

Clone the repository in your local machine
```bash
$ git clone git@github.com:m-romano/spring-store.git
```
### Prerequisites

[Docker](https://docs.docker.com/engine/install/)

[Docker Compose](https://docs.docker.com/compose/install/)

[PostgreSQL](https://www.postgresql.org/download/)

### Installing
Open your favorite IDE and open the terminal window.

If the IDE do not download the dependencies automatically, run
```bash
$ ./mvnw dependency:resolve
```

then run the project through the IDE or run

```bash
$ ./mvnw spring-boot:run
```

You will get a bunch of debug logs, but you should get an output like this in the terminal window
```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-04T03:15:18.604+0200 INFO Starting SpringstoreApplication using Java 22 with PID 38651 (/home/sky/Downloads/springstore/target/classes started by sky in /home/sky/Downloads/springstore)
2024-06-04T03:15:18.609+0200 DEBUG Running with Spring Boot v3.3.0, Spring v6.1.8
2024-06-04T03:15:18.610+0200 INFO No active profile set, falling back to 1 default profile: "default"
2024-06-04T03:15:18.611+0200 DEBUG Loading source class com.mromanode.springstore.SpringstoreApplication
2024-06-04T03:15:18.643+0200 DEBUG Matching URLs for reloading : [file:/home/sky/Downloads/springstore/target/classes/]
2024-06-04T03:15:18.644+0200 DEBUG Included patterns for restart : []
2024-06-04T03:15:18.644+0200 DEBUG Excluded patterns for restart : [/spring-boot-starter-[\w-]+/, /spring-boot/(bin|build|out)/, /spring-boot-starter/(bin|build|out)/, /spring-boot-devtools/(bin|build|out)/, /spring-boot-actuator/(bin|build|out)/, /spring-boot-autoconfigure/(bin|build|out)/]
2024-06-04T03:15:18.644+0200 INFO Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-06-04T03:15:18.644+0200 INFO For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-06-04T03:15:18.670+0200 INFO Using Docker Compose file '/home/sky/Downloads/springstore/compose.yaml'
2024-06-04T03:15:19.155+0200 INFO  Container springstore-postgres-1  Created
2024-06-04T03:15:19.155+0200 INFO  Container springstore-postgres-1  Starting
2024-06-04T03:15:19.513+0200 INFO  Container springstore-postgres-1  Started
2024-06-04T03:15:19.513+0200 INFO  Container springstore-postgres-1  Waiting
2024-06-04T03:15:20.018+0200 INFO  Container springstore-postgres-1  Healthy

Omitted outputs...
```

### Docker

You can pull the latest docker image from docker hub
```bash
$ docker pull mromanode/springstore
```

Or build you own image from running
```bash
$ docker build --platform linux/amd64 -t springstore-docker .
```

change your platform respectively.

Last, run 
```bash
docker run -p 8080:8080 -t springstore-docker
```


### Docker compose support
Start your application by running docker compose command:

```bash
$ docker compose up -d
```

Your container list should show two containers running and their port mappings, as seen below:
```bash
$ docker image ls
REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
liquibase    latest    85f72acd9e6e   3 days ago    387MB
postgres     latest    cff6b68a194a   4 weeks ago   432MB

$ docker ps -a
CONTAINER ID   IMAGE              COMMAND                  CREATED              STATUS                      PORTS                                         NAMES
1a8161e68897   liquibase:latest   "/liquibase/docker-e…"   About a minute ago   Exited (0) 59 seconds ago                                                 springstore-liquibase-1
3cc7badc0603   postgres:latest    "docker-entrypoint.s…"   About a minute ago   Up About a minute           0.0.0.0:32768->5432/tcp, :::32768->5432/tcp   springstore-postgres-1
```


## Contributing (Under Development)

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Marco Romano** - *Initial work* - [mromanode](https://github.com/mromanode)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration

## TODO
* Add entities implementation.
* Fix docker overriding local postgresql connection.
* Write mocking and unit tests
* Security: Implement Spring Security for authentication and authorization.
* Monitoring and Metrics: Monitoring tools for application health and performance.
* API Documentation: Swagger for generating API documentation.
* Caching: Integrate caching with Redis.
* Validation: Hibernate validator for validating user input.
* Message Queues: Asynchronous processing.
* Testcontainers: Use docker within tests.
* CI/CD: Continuous integration/deployment
* Microservices: Set up a Eureka server
* Documentation: Comprehensive documentation
*Error tracking
