The framework supports Selenide+TestNG

### Pre-requisite
* JDK 8
* IDE, prefer [IntelliJ Idea CE](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)


### Setting up the project locally:
* git clone https://github.com/vinitabansal9/RCBTest.git
* Ensure TestNG plugin is working
* Rebuild project locally using `mvn clean install`.

The project contains API test.
-------------------------------------------------------------------------------------------------------------
API Tests are covering parsing the JSON content, extracting data, and validating response body.
-------------------------------------------------------------------------------------------------------------
#Execution of API Tests
Under Suites folder-> open RCBPlayerTest.xml and RunAs TestNG Suite.
It executes test case under /TeamRCB/src/test/java/com/validation/APITeamRCB.java
Logs can be seen under console.
#Test 1: Validation of the team has only 4 foreign players
validateForeignPlayers() method filters country of all the players and validates the Foreign players count
#Test 2: Validation of the team has at least 1 wicket keeper
validateWicketKeeper() method filters all the players role and validates the Wicket Keeper count
