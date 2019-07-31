@landingPage
Feature: Landing Page

Background:
Given I launch the browser
Then I launch the website

Scenario: Validate the Landing page is displayed upon entering the valid URL in the address bar
Then I wait for page to load
Then I assert for element with xpath "//*[@id='hb-men']/img"

Scenario: Verify that application is set to English language by default
Then I assert for text "Today's brightest minds." with xpath "//div[@class='banner-content animated fadeInUp']/h1"