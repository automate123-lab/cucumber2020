Feature: Login Feature

#Background: check the browser
 #Given The chrome browser to be ready
# And close the browser

@Smoke @Regression
Scenario: Successful login with valid credentials
Given User launches the chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And click on login button
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on logout link
Then Page Title should be "Your store. Login"
And close the browser

@Regression
Scenario Outline: Login Data Driven
Given User launches the chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "<email>" and password as "<password>"
And click on login button
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on logout link
Then Page Title should be "Your store. Login"
And close the browser

Examples:
|    email                |password|
|admin@yourstore.com      |admin   |
 |admin123@yourstore.com  |admin123|