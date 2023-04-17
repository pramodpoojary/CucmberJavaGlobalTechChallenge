#  Cucmber BDD Framework Magento
This repository contains the solution for a web automation technical challenge. The solution has been implemented using Cucumber BDD framework with JUnit as a unit testing framework and Java language, all with the latest versions. Maven has been used as a build management tool. Page Object Model (POM) using Page Factory has been used as a design pattern.
## Prerequisites
The following software is required to be installed on your system before running the tests:<br>
•	Java <br>
•	Maven <br>
•	Web browser (Chrome, Firefox, etc.) <br>
## Running the tests
The tests can be executed using the following Maven command: <br>
``` mvn clean verify ``` <br>
Before running the tests, ensure that all the required dependencies are resolved and the Configuration.properties file is configured with the correct browser selection, URL, and wait times.
## Design pattern
The Page Object Model (POM) design pattern has been used to organize the code for better readability, maintenance, and reusability. All the tests have been designed in a single page(Add to cart), but as a best practice, separate page and step definition classes can be used for each page. An Actions class can also be added between step definition and pages to increase code reusability.
## Logging
Log4j has been used for logging to provide better visibility and troubleshooting of the test execution.
## Reporting and running configurations
Running configurations and reporting are handled in the RunCucumberTest.java file. The execution reports are generated in the target/cucumber-reports folder.
## Conclusion
This solution provides a scalable and maintainable approach to automate web applications using Cucumber BDD framework with POM design pattern and JUnit as a unit testing framework. Please feel free to explore the code and provide your valuable feedback.

## Test specific Observations/Discoveries 
•	Check cart total is $116.00 is failing as actual result coming out to be $145<br>
•	Had to input address and email while checking out the product for now i have hardcoded the data due to time constraint , we can manage this data in feature file or seprate file and read it at run time.<br>
• And the tests got bit complex due to incomplete navigations in the magento website (for eg: unable to navigate back to cart from checkout page)
