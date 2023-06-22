# Trivago Test Framework
`Test framework for Trivago with tests for web, mobile.`

![Trivago_logo](https://1000logos.net/wp-content/uploads/2020/09/Trivago-logo.png)

**Languages**: Java & Gherkin

**BDD**: Cucumber

**Automators**: Selenium (***Web***), UIAutomator2Options (***Android***)

*This framework was created as a learning project and has since grown to a large project with various testcases for web, mobile. Due to complexity the standard variant for web testing is dutch only and for mobile - english. Below follows a large and detailed explanation of the entire framework and code choices made along the way in hopes to create a 'Test framework bible' for each and everyone to read and learn from. This project is the first of many, all of which will be build with the same intention in mind.*

*iOS testing has been excluded due to the unavailability of the trivago.ipa file. Android apk files can be commonly obtained by sources like 'apkmirror'. Unfortunately iOS does not have an equivalent and this is a selfmade project, so I did not have access to any develop/tester perks a member of the trivago development team would have. Therefore, iOS testing is excluded.*

*API testing has been excluded due to the protection by Trivago. All API calls result in a 403 statuscode. Meaning the request made is forbidden and unable to be included in this testing framework.*


## Project structure

....

## Project setup

### Clone this repository
```
git clone https://github.com/Larsdotpy/Trivago_Testframework.git
```
### Dependencies
Check if all the dependencies in the pom.xml file are still up-to-date. If not, some errors might occur and the framework will either fail or not be running smoothly.

## MVN test parameters
No parameters: Default value, for web this means that the default browser (CHROME) will be selected. For mobile this means that the default OS (ANDROID) will be selected. The API tests do not require a specific parameter for an agent. 

**Chrome**
```
mvn test -Dbrowser=chrome -Dtest=RunWebTest
```
**Firefox**
```
mvn test -Dbrowser=firefox -Dtest=RunWebTest
```
**Android**
```
mvn test -Dbrowser=android -Dtest=RunAppTest
```

.....

