package com.devskiller.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private static final String URL = "http://localhost:8089/index.html";
	
    private final WebDriver driver;
    
    @FindBy(how = How.NAME, using = "username")
    WebElement loginPage_txt_username;
    
    @FindBy(how = How.NAME, using = "username")
    WebElement loginPage_txt_password;
    
    @FindBy(how = How.ID, using = "loginButton")
    WebElement loginPage_btn_loginbutton;
    
    @FindBy(how = How.CSS, using = "span[class=\"error-message\"]")
    WebElement loginPage_message_invalidCredentials;
    
    @FindBy(how = How.NAME, using = "rememberMe")
    WebElement loginPage_checkbox_rememeberme;
    
    WebDriverWait wait = null;
   

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void open(String... queryParams) {
        String queryString = QueryStringBuilder.buildQueryString(queryParams);
        driver.get(URL + queryString);
    }

    public void fillCredentials(String username, String password) {
    	 
    	//Entering the UserName
    	wait.until(ExpectedConditions.visibilityOf(loginPage_txt_username));	
    	loginPage_txt_username.sendKeys(username);
     
    	//Entering the Password
    	wait.until(ExpectedConditions.visibilityOf(loginPage_txt_password));
    	loginPage_txt_password.sendKeys(password);
    }

    public void clickLoginButton() {
    	//Clicking on the login button
    	wait.until(ExpectedConditions.elementToBeClickable(loginPage_btn_loginbutton));
    	loginPage_btn_loginbutton.click();
    }

    public String getErrorMessage() {
    	//validating the element is visible and returning the error message text 
    	WaitUntillElementVisible("span[class=\\\"error-message\\\"]", "css");
    	return loginPage_message_invalidCredentials.getText();
    }

    public void setRememberMeChecked(boolean checked) {
        
    	boolean checkboxstatus = loginPage_checkbox_rememeberme.isSelected();
    	
    	if (checked && checkboxstatus)
        {
    		loginPage_checkbox_rememeberme.click();
        }
    }


    //We can define this common function in the common utilities class file. As this method checks the element for every 3 secs until the given
    //iterations are completed. I'm defining this class in the login page which is not correct as per the framework standard, as I don't have scope 
    //to create the common utilities class file.
    public void WaitUntillElementVisible(String _webElementXpath, String typeofIdentifier)
    {
    	boolean _webElementExist = false;
        int _iterationCount = 0;

        do
        {
            try
            {
                switch (typeofIdentifier)
                {
                    case "xpath":

                        _webElementExist = driver.findElement(By.xpath(_webElementXpath)).isDisplayed();

                        StaticWait(3000);

                        break;

                    case "css":

                        _webElementExist = driver.findElement(By.cssSelector(_webElementXpath)).isDisplayed();

                        StaticWait(3000);

                        break;
                }

                _iterationCount++;
            }
            catch (Exception ex)
            {
                continue;
            }

        } while (!_webElementExist && _iterationCount <= 9);
    }
    
    //We can define this common function in the common utilities class file. As this method checks the element for every 3 secs until the given
    //iterations are completed. I'm defining this class in the login page which is not correct as per the framework standard, as I don't have scope 
    //to create the common utilities class file.
    private void StaticWait(int staticWaitInMilliSeconds)
    {
        try {
			Thread.sleep(staticWaitInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}