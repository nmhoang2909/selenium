# Automation Testing - Selenium

A framework of selenium run with Chrome and Firefox

## Prerequisites

* Have [java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed

* Have [maven](http://maven.apache.org/) installed

## Running the tests
Run by Command Line:

```bash
Run single test:
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

```bash
Run parallel test:
mvn clean test -Dsurefire.suiteXmlFiles=testng_parallel.xml
```

## Checking HTML report

After execute test, check HTML report at:
```bash
/src/test/java/extentReport/index.html
```
