# taf-mobile-de
TAF is an automation framework for Mobile.de api with some in-built features that provides solutions to some common automation problems.
It consists of a package with api test.

API testsuites have the next structures: 

1) LoginTest
   - checkloginWithInvalidCredentials test
   - checkloginWithEmptyEmailAndEnyPassword test
   - checkloginWithEmptyPasswordAndAnyEmail test
3) Open Website tests
   - checkOpeningWebSite( check status code)
5) Select car test
   - check Selecting Car By Id test
  
Taf is based on:
- Jdk 17
- Maven (pom.xml)
- RestAssured
- TestNG

Installation:
1.clone repositorium. Use  git clone https://github.com/your-repo.git
2. redirect to directirium - cd your-repo
3. add dependancies to your maven project
4. run testsuites and test api

if you need help, please contact us: i.ryzhenko@alcosi.eu
   
