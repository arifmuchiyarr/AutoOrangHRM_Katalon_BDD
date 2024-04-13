$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/fathi/Katalon Studio/OrangeHRM/Include/features/Login.feature");
formatter.feature({
  "name": "Login feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Skenario Login dengan form username invalid",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login_invalid_username"
    }
  ]
});
formatter.step({
  "name": "I Open Browser and navigate to Website",
  "keyword": "Given "
});
formatter.match({
  "location": "login.OpenBrowserAndNavigateToWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click login button with invalid input username",
  "keyword": "When "
});
formatter.match({
  "location": "login.ClickLoginWithinvalidusername()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify get error error Invalid Credential",
  "keyword": "And "
});
formatter.match({
  "location": "login.I_verify_getErrorOinvalidCredential()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify still on the login page",
  "keyword": "Then "
});
formatter.match({
  "location": "login.I_verify_still_on_Login_Page()"
});
formatter.result({
  "status": "passed"
});
});