# Show case project

This repository is  a show case project that implements restAssured to test one API but also UI test using Java/Selenium and cucumber. 

About the project:

I have created a maven project implementing the  page object model. I have written the tests in java using Junit and cucumber.

About the tests:

Cookies : I have written some test to check the cookies of the website, they can be found in CookieNotificationTest.java. This is a basic test to check  what cookies have  been set up  but also to interact with them
Saving calculator : I have created some test around the scores that the calculator can provide and have interact with a slider to change the values and check results in the total score section.
API Loging : I wrote a test using  reassured to check the results of the api when there is an incorrect user or password entered in the website. I have implemented the build pattern to write the test. ( test can be found UnknownEmailAccountLogin.java package package com.clearScore.test.scenario)
Test reports : I have used maven-surefire-report to run the test reports. 

Other considerations :

In order to execute this test, Java 8 and the JDK need to be installed. 

* The tests have been set up to be run  with a chrome browser in  windows. Please make sure that you have the chromedriver installed in the user.dir directory /src/test/resources/driver/ in order to run the test
* Please ensure that maven is installed . In order to run the reports use the following commands from your terminal:
o	mvn clean test
o	mvn surefire-report:report-only

