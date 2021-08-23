# About Project
The goal of this project to automate the process of applying loan. It uses Selenium WebDriver, Cucumber(BDD), Maven and TestNG. This automation framework uses ***Page Object Model*** design pattern.

## Pre-requisites

1. Java8
2. Maven
3. Set JAVA_HOME and MAVEN_HOME in your path variable
4. Cucumber (BDD)
5. TestNG
6. Eclipse IDE / IntelliJ IDE
7. chromedriver.exe
8. ExtentReports Cucumber

##Framework Overview

1. This project is a Maven project
2. It uses Cucumber and its written in Behavior Driven Development (BDD) approach. The scenario is mentioned in the feature file and uses Gherkin language - ***Given, When, Then*** statements
3. It has 3 layer:
    - Features - this folder will have all feature files that comprises of scenario(s)
    - StepDefinitions - this folder will have stepdefinitions associated with feature files
    - PageObject - this folder will have the page objects for all the pages in the web application
4. ExtentReports: After running the tests, a pretty report is generated to see the results in a structured format. These reports can be found at location test-output/SparkReport/index.html

##Before Running the project 
1. Please download ***chromedriver.exe*** and replace the path to this driver in setUp() method in /src/test/java/stepDefinitions/ConfigSteps.java
2. Make sure to have unique email id in the feature file.

##How to run Project

1. Use Eclipse/Intellij IDE to load this project.
2. Find TestRunner.java in src/test/java folder, right click on this file and ***Run As TestNg*** (for this you might have to install TestNg plugin on your IDE)
3. To run this feature/scenario in parallel using ***multiple threads***, make sure you pass atleast 2 examples in the feature file.

##Reports

![image](https://user-images.githubusercontent.com/9261428/130512712-0cd3916a-60b0-4ab0-b2ee-4d293b9884aa.png)

![image](https://user-images.githubusercontent.com/9261428/130512837-d72b594e-f546-4df5-9459-48ac44b4f148.png)

![image](https://user-images.githubusercontent.com/9261428/130513027-19a2e20a-dcab-4f81-8c14-734e20655bbb.png)

