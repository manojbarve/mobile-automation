Introduction:
This repository contains a lightweight mobile automation framework for BDD (Behavior-Driven Development) using Appium, Java, JUnit, Maven, and Cucumber. The framework is designed for mobile automation and utilizes an open-source mobile app called MYDemo (available for both iOS and Android) for testing purposes.

Framework Features:

Supports iOS and Android platforms.
Emphasizes code reusability, code readability, and scalability.
Implements the Page Object Model design pattern.
Tests are written in BDD Gherkin format using Cucumber feature files, providing a living documentation in the test report.
Step definitions are implemented as separate classes and called from the BDD tests.
The framework includes a test scenario for login verification, swipe action, and element navigation.
Extent Reports is used for generating detailed test reports after test execution.
Test Execution:
To execute the tests, follow these steps:

Ensure that the necessary prerequisites for running Appium tests are met.
Set the environment variables and update the Appium server details and device/simulator details in the configuration file.
Open the command line and run the following commands:
For iOS: mvn clean test -Dplatform=ios
For Android: mvn clean test -Dplatform=android
Once the tests are executed, the HTML test report can be found at "target/test-output/testReport/report.html".**BDD-Java-APPIUM-Cucumber-Junit-Maven Light weight Mobile Automation Framework.**

**Introduction:**

This repository created for mobile automation with appium for mobile automation. This test automation framework designed with help of Appium,Java,Junit,Maven and Cucumber.

For testing purpose - an open source mobile app from MYDemo(iOS & aOS) app has been used in the framework.

**Framework Design & Considerations:**
- Supports iOS and Android
- Code reusability, Code readability and Scalable autoamtion framework.
- Page object Model has been used in this framework.
- Tests are written in BDD Gherkin format in Cucumber feature files and it is represented as a living documentation in the test report.
- These step-definitions class which are in-turn called from BDD tests.
- A test scenario to validate Login Verification and Swipe action, navigation to element are covered in the framework.
- Extent reports has been used for reporting purpose after test execution.

**Executing the tests:**
Once pre-requisites for appium test, set environment variables, appium server details, device/simulator details updated in config file then run the test with following commands from command line.

For ios: Run mvn clean test -Dplatform=ios
For android: Run mvn clean test -Dplatform=android

HTML Test report available in "target/test-output/testReport/report.html" after execution.

**Sample Report:**

![image](https://github.com/prabuChinnavar/zing-assessment-mobile-automation/assets/149061770/cf7d879c-4d65-4bdb-9a85-70c195da5273)
![image](https://github.com/prabuChinnavar/zing-assessment-mobile-automation/assets/149061770/d2ae6917-9903-4df3-a2ba-9a9265e5e3ac)




