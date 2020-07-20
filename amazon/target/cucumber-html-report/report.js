$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 2,
  "name": "Executing the login feature",
  "description": "",
  "id": "executing-the-login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@BeforeLogin"
    },
    {
      "line": 1,
      "name": "@AfterLogin"
    }
  ]
});
formatter.before({
  "duration": 226617,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I start the automation",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I executing the hookclass",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.iStartTheAutomation()"
});
formatter.result({
  "duration": 121677895,
  "status": "passed"
});
formatter.match({
  "location": "Login.iExecutingTheHookclass()"
});
formatter.result({
  "duration": 52228,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "SearchItem",
  "description": "",
  "id": "executing-the-login-feature;searchitem",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 35,
      "name": "@SearchItem"
    }
  ]
});
formatter.step({
  "line": 37,
  "name": "I wait for 20 seconds",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "I wait until \"Category\" appears",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I click on \"Category\"",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "I wait for 10 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "I wait until \"TV, Appliances\" appears",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "I scroll till \"TV, Appliances\"",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "I wait for 5 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I click on \"TV, Appliances\"",
  "keyword": "And "
});
formatter.step({
  "line": 45,
  "name": "I wait until \"Televisions\" appears",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I click on \"Televisions\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I wait for 40 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I scroll till \"View all\"",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "I click on \"View all 40 \u0026 43 TVs\"",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "I wait for 20 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "I scroll till \"Sony Bravia 108 cm\"",
  "keyword": "And "
});
formatter.step({
  "line": 52,
  "name": "I wait for 20 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "I click on \"Sony Bravia 801\"",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "I scroll till \"Add to Cart\"",
  "keyword": "And "
});
formatter.step({
  "line": 55,
  "name": "I wait for 20 seconds",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I click on \"Add to Cart\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 11
    }
  ],
  "location": "GeneralStep.iWaitForMinites(int)"
});
formatter.result({
  "duration": 30561997,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Category",
      "offset": 14
    },
    {
      "val": "appears",
      "offset": 24
    }
  ],
  "location": "GeneralStep.i_wait_until(String,String)"
});
