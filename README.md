# SauceDemo
This framework is basically established on "Maven-Selenium-Cucumber-JUnit" test automation tools.

I have used Java and developed my framework based on Page Object Model.
This framework is a hybrid framework which supports both BDD and Data Driven Testing.
I define application behaviors by using Gherkin language in feature files.
I use data tables in order to implement Data Driven Testing.
The structure of the framework and the interactions among the packages.

Initially I use pom.xml file to centralize dependencies and to configure necessary plugins and profiles.

I also have configuration.properties file. In this file, I store some common data and environment description such as browser, credentials, URL for UI Testing. All those data are used with the help of ConfigurationReader class in my utilities package.

I keep Feature file under the Resources directory.

I use feature package for UI.

In feature file, I have scenarios in which I define my test steps with a simple English by using Gherkin language key words such as Feature, Scenario, Given, When, Then, And. I also use tags in order to generate my tests.

After declaration of the all test steps in my feature file, I create a Java class in StepDefinitions package which corresponds a single feature file. In each step definition class, I write the identical steps in order to implement assertions.

In my Pages package. As I mentioned above, I implement POM in my framework to prevent code redundancy, make the codes reusable and easy to maintain. I also implement some Object Oriented Programming Concepts in my framework such as inheritance PageBase and other page classes, polymorphism especially while using Collections Framework... I use a PageBase class which contains some common methods. For each single page of the application, I create a separate java class which extends to PageBase class. By doing so, I reduce the code repetition and it makes my framework more interactive among the pages. In each page I implement Page Factory Design Pattern by using PageFactory.initElements(driver, this) method. By doing so, I locate all the web elements by using @FindBy annotation instead of using findElement() method. After locating all necessary WebElements, I call them from related method in the same page class and I return only the actual result for each functionality.

I create objects from corresponding step definition class and related page class. By using these objects, I can invoke all the related methods in each step and I can compare the actual result which comes from page class and the expected result which mostly comes from feature file.

I also have Browser Utilities, Driver class, ConfigurationReader in utilities package.

In Driver class, I have different browser options such as Chrome, ChromeHeadless, FireFox, FireFox Headless, IE, Safari.

My framework can be run in headless and multiple browsers mode and also it is enabled for parallel testing by using a private ThreadLocal WebDriver object and private constructor and also a public getter method. In Driver Class, I implement parallel testing, I create "LocalThread" object which generates as much driver as I define in my pom.xml file.

I also have Hooks Class in StepDefinitions package and I use @Before/@After annotations to gather all common setup and teardown requirements for my step definitions such as launching driver, implicit wait, deleting cookies,taking screenshot for failed scenarios.

Besides all these setups, I use Runners package in order run scenarios. I have three runner class in my framework. First one is CucumberRunner and the second one is FailedRunner class and the other is ParallelRunner. I use @RunWith(Cucumber.class) annotation to run my test cases with the help of JUnit. I have some Cucumber options in runner class such as features, glue, plugin, monochrome, dryRun and tags. Initially I execute test cases as dryRun to make sure whether feature file and stepDefinition are mapping then I execute my test cases as dryRun is false.

This framework produces "default cucumber reports". I also use very detailed "Cucumber HTML Reports" which generates bar charts, pie charts and tables with the help of cucumber reports plugin in pom.xml file.

By using maven commends in terminal, I can run tests.
