# SauceDemo E-Commerce Automation Framework

A Selenium WebDriver automation framework built using Java, TestNG, Maven, and Page Object Model (POM) for testing the SauceDemo e-commerce web application.

## Tech Stack

- Java
- Selenium WebDriver 4.33.0
- TestNG 7.9.0
- Maven
- Page Object Model (POM)
- Apache POI 5.4.1
- Extent Reports 5.1.2
- SLF4J / Logback
- Jenkins
- Git / GitHub

## Framework Features

- Page Object Model (POM) based framework
- Reusable BasePage for common Selenium operations
- Explicit waits using a dedicated WaitUtil
- Configurable browser and application URL
- Chrome and Edge browser support
- ThreadLocal WebDriver management
- Data-driven testing using Excel and Apache POI
- TestNG DataProviders
- Smoke and Regression test suites
- TestNG listener implementation
- Extent Reports integration
- Failure screenshot capture
- Base64 screenshots attached to Extent Reports
- SLF4J / Logback logging
- Jenkins CI execution
- Automated Extent Report publishing in Jenkins

## Project Structure

```text
SauceDemoAutomation
|
+-- src
|   |
|   +-- main
|   |   |
|   |   +-- java
|   |   |   |
|   |   |   +-- base
|   |   |   |   +-- BasePage.java
|   |   |   |
|   |   |   +-- pages
|   |   |   |   +-- CartPage.java
|   |   |   |   +-- CheckoutPage.java
|   |   |   |   +-- HomePage.java
|   |   |   |   +-- LoginPage.java
|   |   |   |   +-- ProductsPage.java
|   |   |   |
|   |   |   +-- utils
|   |   |       +-- BrowserFactory.java
|   |   |       +-- ConfigReader.java
|   |   |       +-- ExcelUtility.java
|   |   |       +-- ExtentManager.java
|   |   |       +-- LogUtil.java
|   |   |       +-- ScreenshotUtil.java
|   |   |       +-- WaitUtil.java
|   |   |
|   |   +-- resources
|   |       +-- config.properties
|   |       +-- logback.xml
|   |
|   +-- test
|       |
|       +-- java
|       |   |
|       |   +-- base
|       |   |   +-- BaseTest.java
|       |   |
|       |   +-- data
|       |   |   +-- TestData.java
|       |   |
|       |   +-- listeners
|       |   |   +-- TestListener.java
|       |   |
|       |   +-- tests
|       |       +-- CartTest.java
|       |       +-- CheckoutTest.java
|       |       +-- LoginTest.java
|       |       +-- NegativeLoginTest.java
|       |
|       +-- resources
|           +-- testdata
|           |   +-- LoginData.xlsx
|           +-- regression-testng.xml
|           +-- smoke-testng.xml
|           +-- testng.xml
|
+-- pom.xml
+-- README.md
+-- .gitignore

Page Object Model

The framework follows the Page Object Model design pattern.

Page-specific locators and actions are maintained in dedicated page classes, while common Selenium operations are centralized in BasePage.

Page Objects
LoginPage
ProductsPage
HomePage
CartPage
CheckoutPage
BasePage

BasePage provides reusable operations including:

clearAndType()
click()
getText()
isDisplayed()

These operations use the framework's explicit wait utility.

Test Data Management

The framework supports data-driven testing using Excel and Apache POI.

Login test data is maintained in:

src/test/resources/testdata/LoginData.xlsx

ExcelUtility is responsible for reading workbook, sheet, row, and cell data.

The TestData class provides TestNG DataProviders for valid and invalid login scenarios.

The Excel-based login testing covers:

standard_user
problem_user
performance_glitch_user
Test Scenarios
Login
Valid login
Multiple valid users using Excel data
Invalid username/password
Invalid username
Missing username
Missing password
Cart
Add product to cart
Open cart
Verify cart title
Verify product is displayed
Remove product
Verify product is removed
Checkout
Add product to cart
Navigate to cart
Navigate to checkout
Enter customer information
Continue to checkout overview
Verify checkout overview
Complete the order
Verify order confirmation
TestNG Suites

The framework contains separate TestNG suites for selective execution.

Smoke Suite
src/test/resources/smoke-testng.xml

Covers critical business workflows such as login, cart, and checkout.

Regression Suite
src/test/resources/regression-testng.xml

Covers broader regression scenarios including negative login testing.

Main TestNG Configuration
src/test/resources/testng.xml

Provides the main TestNG execution configuration.

TestNG Listener

The framework uses a custom TestListener to integrate TestNG execution with Extent Reports.

The listener handles:

Test start
Test success
Test failure
Test skipped
Extent Report flushing

For failed tests, the listener:

Captures a screenshot and saves it to the screenshots directory.
Captures the screenshot as Base64.
Attaches the screenshot directly to the Extent Report.
Marks the test as failed.

ThreadLocal is used for ExtentTest management.

Reporting

The framework uses Extent Reports for test execution reporting.

The report includes:

Test name
Test description
Author
Test status
Execution information
Failure details
Failure screenshots
Logging

The framework uses SLF4J with Logback for logging.

Logging configuration is maintained in:

src/main/resources/logback.xml

Page-level actions such as entering credentials and clicking the login button are logged during execution.

Screenshot Handling

ScreenshotUtil provides two screenshot capabilities:

File Screenshot

Failure screenshots can be saved to the screenshots directory.

Base64 Screenshot

Screenshots can also be captured as Base64 and attached directly to Extent Reports.

Browser Configuration

Browser and application URL are maintained in:

src/main/resources/config.properties

Example:

browser=chrome
url=https://www.saucedemo.com/

BrowserFactory currently supports:

Chrome
Edge
WebDriver Management

BaseTest manages the WebDriver lifecycle using ThreadLocal<WebDriver>.

Before each test:

Reads browser configuration.
Creates the required browser.
Stores the driver in ThreadLocal.
Maximizes the browser.
Opens the configured application URL.

After each test:

Quits the browser.
Removes the ThreadLocal driver.
Explicit Waits

The framework uses a dedicated WaitUtil instead of hard-coded Thread.sleep() calls.

Reusable waits are used for:

Waiting for elements to become visible
Waiting for elements to become clickable
Jenkins CI

The project is integrated with Jenkins for automated test execution.

The Jenkins job:

Executes the Maven/TestNG test suite
Runs the automation tests
Generates the Extent Report
Archives/publishes the HTML report
Latest Verified Jenkins Execution
Tests run: 9
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
Maven Execution

Tests can be executed using Maven:

mvn clean test
Framework Execution Flow
TestNG Suite
     |
     v
BaseTest
     |
     v
BrowserFactory
     |
     v
ConfigReader
     |
     v
WebDriver
     |
     v
Page Objects
     |
     v
BasePage + WaitUtil
     |
     v
Test Execution
     |
     v
TestListener
     |
     v
Extent Reports
     |
     v
Failure Screenshot
     |
     v
Jenkins CI
     |
     v
Published Test Report
Key Design Principles
Page Object Model
Separation of test logic and page logic
Reusable utility classes
Explicit synchronization
Data-driven testing
Configurable test execution
Centralized reporting
Centralized logging
Failure screenshot capture
Smoke/Regression suite separation
CI-based test execution


## Jenkins CI

Integrated the framework with Jenkins for automated Maven/TestNG execution and Extent Report publishing.

- Automated test execution through Jenkins
- Maven-based test execution
- Extent Report generation
- HTML report archiving/publishing


## Author

Bismay Pati
