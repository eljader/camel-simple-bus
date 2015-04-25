# camel-simple-bus

Base

feature:install webconsole

feature:install	camel-saxon

feature:install camel-jpa

restart smx

JDBC Driver (for DB2)

mvn install:install-file -Dfile="db2jcc.jar" -DgroupId=com.ibm.db2.jdbc -DartifactId=db2jcc -Dversion=9.7 -Dpackaging=jar

install -s wrap:mvn:com.ibm.db2.jdbc/db2jcc

Features 

feature:repo-add mvn:ru.cinimex/features/1.0-SNAPSHOT/xml/features

feature:install eclipselink-csb
