@landingPage
Feature: Landing Page

Background:
Given I launch the browser
Then I launch the website

Scenario: Validate the Landing page is displayed upon entering the valid URL in the address bar
Then I assert for element with xpath "//*[@id='hb-menu']/img"


