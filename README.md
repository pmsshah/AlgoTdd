# java
**** 07/30/2022 Array balance bracket example *****
Branch: ARRAY_ALOG
Problem: Brackets should be balanced.
gradlew.bat clean
gradlew.bat test 
Open file: C:\Code\codding\AlgoTdd\build\reports\tests\test\index.html
gradlew test --tests "com.example.array.ArrayAlgoTest.*"

***** Use case1: Say hello world, rest call. ******
* Location: java\egTest
* What are we doing? Learning?
	* TDD, test driven development.
	* Creating console application with test.
	* Summary:
		set up the console application, add test class, test cases which will fail. 
		add remaning code/class make test case work. 
		Add another test, test case will fail, improve the prod code to make test work. 
		Improve the build.gradle to add paramterization. 
	* Summary:
		add the appropriate support to run test as commandline using gradle. 
* What tools needed?
	* Inteleji, Junit5, etc.
	* ShortCuts
		ALT + ENTER to add auto generated code.
		CTRL+ALT+V to complete the instansiation.
		CTRL+SHIFT+F10 run the test case.
	* Gradle command
		gradlew.bat clean build --> Clean build
		gradlew.bat build --> Just build
		gradlew.bat run -> Run application.
		gradlew.bat test -> to run unit test.
	* URLs
		https://www.jetbrains.com/help/idea/tdd-with-intellij-idea.html#iterate
		https://www.baeldung.com/parameterized-tests-junit-5
		https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
* How it will do? Steps.
	* New Project -> Gradle -> Select Java + Groove --> Project Name 
	* create package com.example.demo at Main/Java
	* cretae Java Test clsass at test/Java com.example.demo.MoodAnalyserTest
	* Use ALT+INSERT and create method testMoodAnalysis
	* Type new MoodAnalyser(), ALT+ENTER, create class com.example.demo.MoodAnalyser at Main/Java
	* Prese CTRL+ALT+V at end of new MoodAnalyser(), it will implement instance.
		* Type moodAnalyser.analyseMood("This is a sad message"); Type ALT+ENTER
		* Implement class method 
		    public String analyseMood(String message) {
		        return null;
    			}
    		* In Test class type CTRL+ALT+V and instantiae mood local variable.
    	* improve build.gradle like
    		dependencies {
		    testImplementation(
		            'org.hamcrest:hamcrest-library:2.2'
		    )
		} OR
		
		dependencies {
		    implementation 'org.codehaus.groovy:groovy-all:3.0.5'
		    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
		    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
		}
	* within test method add
		assertThat(mood, CoreMatchers.is("SAD"));
		or Assert.assertEquals(mood, "SAD");
	* Run Test CTRL+SHIFT+F10
		* Test case will fail, fix original code return "SAD" and rerun, it should pass.
	* Add another test case, ALT+INSERT, HappyMoods(), copy same code but with "HAPPY" mood. 
		* Run test CTRL+SHIFT+F10, it will fail, correct prod code like to make test work. 
		*         if (message.contains(("sad"))) {
				    return "SAD";
				}
				return "HAPPY";

	* Add last two rows for paramerization and suite thingi. 
		dependencies {
		    implementation 'org.codehaus.groovy:groovy-all:3.0.5'
		    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
		    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
		    testImplementation 'org.junit.jupiter:junit-jupiter-params:5.8.1'
		    testRuntimeOnly 'org.junit.platform:junit-platform-suite:1.8.1'
		}
	* Add parameterization test. 
	* How to run command line
		run gradlew.bat clean build
		run gradlew.bat run -> Run application.
		run gradlew.bat test -> to run unit test.
			see result C:\Code\codding\java\egTest\build\reports\tests\test\index.html
	* Add
		test {
		    useJUnitPlatform()
		    testLogging {
			events "passed", "skipped", "failed", "standardOut", "standardError"
		    }
		}
	* Rerun command line
		* each test case will display.
	* add parametrized test
		run gradlew.bat clean build
		run gradlew.bat test -> to run unit test.
			see result C:\Code\codding\AlgoTdd\build\reports\tests\test\index.html
	* add main application, modify build.gradle
		apply plugin: 'application'
		mainClassName = 'com.example.demo.MoodAnalyser'
		applicationDefaultJvmArgs = [
			"-Djava.util.logging.config.file=src/main/resources/logging.properties"
		]
	* run 
		run gradlew.bat clean build
		run gradlew.bat run -> Run application.

* How you will test? 
		run gradlew.bat clean build
		run gradlew.bat run
		run gradlew.bat test -> to run unit test.
			see result C:\Code\codding\java\egTest\build\reports\tests\test\index.html
