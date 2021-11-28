# Weather APP
__Description__

This is a simple Weather APP Rest API to display the forecast of city.
Assumtion : Java 8 and maven 3.8.2 is installed and exists in the classpath

__Build And Run the Program__
Download the weather App project from Git Hub
Unzip the weather App Project.
To build the executable Jar, open the command prompt.
Navigate to project root directory.
run the following maven command in the project root directory (Where we can see POM file):
Command : mvn clean package

It will create a jar weatherApp-v1.jar in <project root> /target directory.

Navigate to target folder : cd target 

To run the program command : java -jar weatherApp-v1.jar

__The program works as follows:__
 1. Once Build and run steps are completed
 2. Tomcat server whould be running on the system
 2. Open the browser and input the url :: http://localhost:8080/weather?city=melbourne
 3. Expected out put sample would be :: {"wind_speed":"7","temperature_degrees":"12"}