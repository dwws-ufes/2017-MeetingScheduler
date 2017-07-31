# 2017-MeetingScheduler
This is a preliminary system to practice Web Development in Java skills, built using [JButler Framework](https://github.com/dwws-ufes/jbutler). The system intends to be a plataform to schedule meetings.

# Requisites
MScheduler was built using [Eclipse Neon 3](http://www.eclipse.org/neon/) IDE and runs over [Wild Fly 10](http://wildfly.org/). Also, it is configured to connect to a [MySQL Database](https://www.mysql.com/).

# Configuration
`standalone.xml`

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

# Team
Pedro

Laercio


