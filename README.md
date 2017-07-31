# 2017-MeetingScheduler
This is a preliminary system to practice Web Development in Java skills, built using [JButler Framework](https://github.com/dwws-ufes/jbutler). The system intends to be a plataform to schedule meetings.

# Requisites
MScheduler was built using [Eclipse Neon 3](http://www.eclipse.org/neon/) IDE and runs over [Wild Fly 10](http://wildfly.org/). Also, it is configured to connect to a [MySQL Database](https://www.mysql.com/).

# Configuration
The database connection is configured at WildFly configuration file `standalone.xml`. It can be edited to specify other connections, if necessary.

```xml
<datasource jta="true" jndi-name="java:jboss/datasources/MScheduler" pool-name="MSchedulerPool" enabled="true" use-java-context="true">
    <connection-url>jdbc:mysql://localhost:3306/mscheduler</connection-url>
    <driver>mysql</driver>
    <security>
      <user-name>mscheduler</user-name>
      <password>mscheduler</password>
    </security>
</datasource>
```
This project uses [Maven](https://maven.apache.org/) as a library dependence manager. So, the libraries used in this project are described in `pom.xml` file.


# Team
Pedro

Laercio


