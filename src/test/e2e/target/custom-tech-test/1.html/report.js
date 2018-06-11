$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Janaki.Kamat/Automation_testing/CucumberProjects/selenium-samples-java/custom-tech-test/src/test/resources/features/TestTech.feature");
formatter.feature({
  "line": 1,
  "name": "Custom Tech feature",
  "description": "",
  "id": "custom-tech-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5632309746,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Submit answers for Arrays Challenge",
  "description": "",
  "id": "custom-tech-feature;submit-answers-for-arrays-challenge",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I open automationpractice website",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I click Render Challenge",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I fill the answers",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "click Submit answers",
  "keyword": "And "
});
formatter.match({
  "location": "ArraysChallenge.i_open_automationpractice_website()"
});
formatter.result({
  "duration": 1057319879,
  "status": "passed"
});
formatter.match({
  "location": "ArraysChallenge.i_click_render_challenge()"
});
formatter.result({
  "duration": 510977439,
  "status": "passed"
});
formatter.match({
  "location": "ArraysChallenge.i_provide_answers_challenge()"
});
formatter.result({
  "duration": 2191472394,
  "status": "passed"
});
formatter.match({
  "location": "ArraysChallenge.click_Submit_answers()"
});
formatter.result({
  "duration": 329887645,
  "status": "passed"
});
formatter.after({
  "duration": 577363478,
  "status": "passed"
});
});