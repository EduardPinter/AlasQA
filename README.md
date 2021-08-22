## Description

- Using Java Selenium with Maven in Intellij enviroment


- Ran on - Ubuntu 20.04.2 LTS 64-bit 3.36.8 GNOME Version

## Installation

Use the Maven to install all the neccessary dependencies from pom.xml file

## Pre-test data changing
[] In order for the resume to be uploaded in OrangeHRM test you need to
- copy absolute path of **resume.txt** from project directory 
- paste the path in **orangeHRMpom/CandidatesPage** file, `protected String filePath = "/home/edi/IdeaProjects/AlasQA/resume.txt";` replacing this absolute path

## Usage

- If running directly with Maven from Intellij enviroment, in **driverInit/TestBase**
change `String property = System.getProperty("browser", "chrome");` to different needed browser


- Using maven commands you can run each individual test through a command in terminal, 
default browser that tests are run on is Chrome

Example:
```bash
mvn clean test -Dtest=NameOfTheTest
```

- For running tests in different browsers(IE,Edge,Firefox) on the end of the lines(from previous command), hit space
 and add the following code (ie - Internet Explorer, edge - Microsoft Edge, firefox - Firefox)

Example: 
```bash
-Dbrowser=firefox
```

## Allure report

- After the test/tests have been run, for getting full allure report run this command in terminal

```bash
allure serve allure-results
```

- After loading the command a page will pop-up in your browser with full information about the tests