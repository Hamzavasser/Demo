package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(name="username")
	private WebElement myUserName;
	@FindBy(name="password")
	private WebElement myPassWord;
	
	public void login(String useName, String myPw) {
		myUserName.sendKeys(useName);
		myPassWord.sendKeys(myPw);
		myUserName.submit();
	}


}
