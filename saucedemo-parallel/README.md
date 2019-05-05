## saucedemo-parallel Workshop Example

This project is the base code for a workshop prepared and given by Sauce Labs, inc. It consists of 
several branches, each of which shows a particular example of a pattern or anti-pattern, and which 
illustrates a particular aspect of parallel test execution.

These examples are loosely based on the Java-TestNG-Selenium sample framework offered [here](https://github.com/saucelabs-sample-test-frameworks/Java-TestNG-Selenium).

The branches are:

* serial - an anti-pattern, illustrating TestNG execution with no parallelism
* parallel_provider - an improvement, which illustrates parallelism via a Data Provider
* parallel_methods - a more preferred method, allowing more control over threading by using parallel methods
* single-browser-config - Sauce Labs' preferred method of running in parallel, removing the Data Provider, and allowing config from System Properties 
* master (which is the same as the 'single-browser-config' branch, the TestNG execution method preferred by Sauce Labs)


[![Travis Status](https://travis-ci.org/saucelabs-sample-test-frameworks/Java-TestNG-Selenium.svg?branch=master)](https://travis-ci.org/saucelabs-sample-test-frameworks/Java-TestNG-Selenium)

This code is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. Your tests and testing environments may require you to modify this framework. Issues regarding this framework should be submitted through GitHub. For questions regarding Sauce Labs integration, please see the Sauce Labs documentation at https://wiki.saucelabs.com/. This framework is not maintained by Sauce Labs Support.

### Environment Setup

1. Global Dependencies
    * [Install Maven](https://maven.apache.org/install.html)
    * Or Install Maven with [Homebrew](http://brew.sh/)
    ```
    $ brew install maven
    ```
2. Sauce Credentials
    * In the terminal export your Sauce Labs Credentials as environmental variables:
    ```
    $ export SAUCE_USERNAME=<your Sauce Labs username>
    $ export SAUCE_ACCESS_KEY=<your Sauce Labs access key>
    ```
3. Project Dependencies
	* Check that Packages are available
	```
	$ cd saucedemo-parallel
	$ mvn test-compile
	```
	* You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file. The updated packages may or may not be compatible with your code.
	```
	$ mvn versions:display-dependency-updates
	```
### Running Tests

Tests in Parallel:

For all branches *other than* 'single-browser-config', execute tests using this command:

	$ mvn clean test
	
For the 'single-browser-config' branch, execute tests using this command:

    $ mvn clean test -DbrowserName=chrome -DbrowserVersion=73.0 -DplatformName="macOS 10.14" &

Note that you can string these together in a series, like the following. Note that this is for demonstration purposes only: it is recommended to use your CI system (Jenkins, TeamCity, etc) to send these commands one at a time. 

    mvn test -DbrowserName=chrome -DbrowserVersion=73.0 -DplatformName="macOS 10.14" &
    mvn test -DbrowserName=chrome -DbrowserVersion=73.0 -DplatformName="Windows 10" &
    mvn test -DbrowserName=chrome -DbrowserVersion=72.0 -DplatformName="macOS 10.14" $
    mvn test -DbrowserName=chrome -DbrowserVersion=72.0 -DplatformName="Windows 10" &
    mvn test -DbrowserName=firefox -DbrowserVersion=66.0 -DplatformName="Windows 10" $
    mvn test -DbrowserName=firefox -DbrowserVersion=66.0 -DplatformName="Windows 7" $
    mvn test -DbrowserName=firefox -DbrowserVersion=66.0 -DplatformName="macOS 10.14" $


Once your tests have executed, check the [Sauce Labs Dashboard](https://app.saucelabs.com/dashboard) for detailed results.

### Advice/Troubleshooting
1. A Java IDE such as IntelliJ or Eclipse is recommended to help troubleshoot potential issues. 
2. There may be additional latency when using a remote webdriver to run tests on Sauce Labs.
    * [Selenium tips regarding Waits](https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Explicit+Waits)

### Resources
##### [Sauce Labs Documentation](https://wiki.saucelabs.com/)

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [TestNg Documentation](http://testng.org/javadocs/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)
