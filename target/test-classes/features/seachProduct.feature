Feature: Search and place the order for products

Scenario: Search experience for product search in home and offer page

Given User is on GreenCart landing page
When User searched for ShortName "Tom" and extract the actual name of product
Then User searched for the "Tom" ShortName in offers page 
And validate product name in landing page matches with offers page