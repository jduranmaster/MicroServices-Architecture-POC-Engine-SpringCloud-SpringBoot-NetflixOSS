FROM dockerfile/java:oracle-java8
MAINTAINER jduranmaster@gmail.com
ADD target/*.jar /data/app.jar
CMD java -Xms256m -Xmx256m -jar /data/app.jar
