# camel-simple-bus

Base

feature:install webconsole

http://localhost:8181/system/console
http://localhost:8181/cxf

feature:install	camel-saxon

feature:install camel-jpa

restart smx

JDBC Driver (for DB2)

mvn install:install-file -Dfile="db2jcc.jar" -DgroupId=com.ibm.db2.jdbc -DartifactId=db2jcc -Dversion=9.7 -Dpackaging=jar

install -s wrap:mvn:com.ibm.db2.jdbc/db2jcc

PG

install -s wrap:mvn:postgresql/postgresql/9.1-901.jdbc4

Features 

feature:repo-add mvn:ru.cinimex/features/1.0-SNAPSHOT/xml/features

feature:install eclipselink-csb

MQ

features:chooseurl activemq 5.9.0
features:install activemq-broker

http://localhost:8181/activemqweb
