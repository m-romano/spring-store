# Spring Store

A deployable e-commerce site for your business. **Still Work In Progress**

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

### Docker
Build and run the app with Compose.

Compose pulls a Postgres image, builds an image for the code, and starts the defined service.
```bash
$ docker compose up
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

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Marco Romano** - *Initial work* - [mromanode](https://github.com/mromanode)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration