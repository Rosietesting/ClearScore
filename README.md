# ClearScore
This repository contains the test of clear score.  This is the readme file with the project detials as well as the additional questions 

ClearScore Tests :
I have created a Java page object framework that also includes test for the API using reassured.  These tests have been built in Java using Intellij. The  mapping bellow shos the  tests required in the exam and the packages/java  classes in the project.
In order to execute this test, Java 8 and the JDK need to be installed. Also, maven is required in order to run the test reports. I have used maven-surefire-report for this purpose.


Test                required	Package	Test
Test 1	            Src/test/java/tests/	CookieNotificationTest.java
.
Test 2	            Src/test/java/com/clearscore/test.scenario	UnknownEmailAccountLogin.java

Test 3	              Src/test/java/tests/	SavingCalculatorTest.java


Other considerations:
•	The tests have been set up to be run  with a chrome browser in  windows. Please make sure that you have the chromedriver installed in the user.dir directory /src/test/resources/driver/ in order to run the test
•	The reports have been created  with maven-surefire-report. Please ensure that maven is installed . In order to run the reports use the following commands from your terminal:
o	mvn clean test
o	mvn surefire-report:report-only

Additional Questions  
1.	How would you integrate the tests you have written into a continuous integration environment?
In order to integrate test into a continuous integration environment, I would consider the following aspects to be set up according to the environment where the test need to run : 

•	Data : 
o	Login credentials
o	Customer data
o	Test expected results data


•	Browser : 
o	Specify  the browsers required or mobile devices for the specific environment

•	URL  configuration and settings : 

o	Configuration of the urls other setting required for the specific environment
o	Additional security aspects that lower environment may not have 

•	Other aspects to consider in terms of the tests itself : 

o	The test should be threat save
o	It should be environment independent
o	Tests should be  configurable independently
o	Clear information when a test  fails and how it fails
o	Reliability  and synchronization
o	Consider to run in parallel 	

2.	How would you make your API test simulate being as realistic a user as possible?

•	Incorporate user agent to the request to simulate devices 
•	Set load and parallel run 
•	Simulate concurrent requests
•	Incorporate data and conditions that exercises different aspects of the API 
•	Consider mock services to simulate a  wider scenarios 

3.	How would you approach running the same tests across mobile devices and different browsers?
•	The devices and browsers should be configurable 
•	The test needs to be able to specify the browser and the environment configuration
•	Define a config file that contains the configuration of the mobile devices 
•	Use of parameters that are independent to the test and can easily be configured 

