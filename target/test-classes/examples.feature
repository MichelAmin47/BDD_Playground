Feature: Example stories

Scenario: Log into the Polteq WebShop
  Given I am on the Polteq WebShop home page
  When I log into the site as a "test" user
  Then I should be taken to the "My Account" page