# Introduction

You are working on tests for user authentication. The login page allows users to log in with valid credentials and can remember the credentials.
A tester not familiar with the Selenium WebDriver has already implemented the tests and left the LoginPage class with not implemented methods.

# Task definition

Your task is to implement four methods at the `LoginPage` class marked with `//TODO implementation` comment. All of them should use the Selenium WebDriver to interact with the `src/test/resources/__files/index.html` page. 
You can assume that the page has already been loaded by the driver. 

Description of methods to be implemented:
1. The `fillCredentials` method should fill in the username and password fields with respective `username` and `password` input arguments. Target fields are defined as `input` elements with `username` and `password` `name` attributes.
2. The `clickLoginButton`method should imitate the click on the login button. This button is defined as `input` element with `button` `type` and `id` attribute equal to `loginButton`.
3. The `getErrorMessage` method should return a text displayed by error message in the `span` element marked with the `error-message` `class` attribute.
The `span` element can appear on the page with random delay, varying from 0 to 3 seconds upon clicking the login button when provided credentials are incorrect. 
4. The `setRememberMeChecked(Boolean checked)` method should mark the `input` of `type` `checkbox` with the `name` attribute equal to `rememberMe` as checked if the method argument is `true`. Otherwise the `input` field should be marked as unchecked. You cannot assume the initial value of the checkbox after webpage loading!

