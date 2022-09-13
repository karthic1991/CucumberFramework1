Feature: Search and place the order for product
@PlaceOrder
Scenario Outline: Place the order and verifying it in add to cart page

Given User is on GreenCart landing page
When User searched for ShortName <Name> and extract the actual name of product
And User added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <name> items in checkout page
And verify user has ability to enter promo code and place order

Examples:
|Name|
|Tom |

