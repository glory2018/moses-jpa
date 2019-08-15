# moses-jpa
spring-data-jpa+thymeleaf
#GIT地址
https://github.com/glory2018/moses-jpa.git
#创建工程
mvn archetype:generate -DgroupId=com.ibm.moses  -DartifactId=moses  -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false
#compile the project
mvn clean compile
#package the built project
mvn clean package
#execute the jar
java -jar
#clean all the compiled class files and jar files in target folder
mvn install
#Change POM.xml to create war executable
<packaging>war</packaging>
#Create manager user in tomcat
<user username="admin" password="1234" roles="manager-gui"/>
