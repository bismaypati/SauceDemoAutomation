# SauceDemo Automation – Selenium Java Automation Framework

A Selenium WebDriver automation framework developed using Java, Selenium, TestNG, Maven, and Page Object Model (POM) for automating the SauceDemo web application.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- Log4j
- Git & GitHub

## Framework Structure

```text
SauceDemoAutomation
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   ├── pages
│   │   │   ├── utils
│   │   │   └── listeners
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       ├── java
│       │   └── tests
│       │
│       └── resources
│           └── regression-testng.xml
│
├── pom.xml
└── README.mdKey Features
Page Object Model (POM) implementation
Reusable BasePage and BaseTest classes
Browser initialization using BrowserFactory
Configuration management using config.properties
Explicit waits using reusable WaitUtil
Screenshot capture on test failure
Extent Reports integration
TestNG listeners for test lifecycle management
Regression suite execution using TestNG XML
Logging using Log4j
Maven-based dependency management
Test Scenarios

The framework currently covers automated testing of the SauceDemo application, including:

Valid login
Invalid login scenarios
Login validation
Product page navigation
Regression test execution
Test Execution
Using Maven
mvn clean test
Using TestNG

The regression suite can be executed using:

src/test/resources/regression-testng.xml
Reporting

The framework uses Extent Reports for test execution reporting.

For failed tests, screenshots are captured and attached to the Extent Report.

Design Pattern

The framework follows the Page Object Model (POM) design pattern.

Page-specific locators and actions are maintained inside dedicated page classes, while reusable functionality is maintained in base classes and utility classes.

This improves:

Maintainability
Reusability
Readability
Scalability
Project Highlights
Selenium 4 automation framework
TestNG-based test execution
Maven project structure
Page Object Model architecture
Reusable utilities
Explicit wait implementation
Automated failure screenshots
Extent reporting
Git/GitHub version control
Author

Bismay Pati

GitHub

View Source Code