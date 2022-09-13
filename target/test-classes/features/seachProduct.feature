Feature: Search and place the order for products
@OffersPage
Scenario Outline: Search experience for product search in home and offer page

Given User is on GreenCart landing page
When User searched for ShortName <Name> and extract the actual name of product
Then User searched for the <Name> ShortName in offers page 
And validate product name in landing page matches with offers page
Examples:
|Name|
|Tom |
|Beet|