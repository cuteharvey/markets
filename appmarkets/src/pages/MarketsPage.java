package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MarketsPage extends PageObject {
	// **** elements ****
	@FindBy(xpath = "//button[contains(text(), 'Quotes')]")
	private WebElement quotesDropdown;
	
	@FindBy(id = "menuContentQueryInput")
	private WebElement quotesTextbox;
	
	private WebElement tradingPair(int rowNum){
		return driver.findElement(By.xpath("//div[@id='rankings']/div[2]/a["+rowNum+"]/div[4]"));
	}
	
	private WebElement tablePrice (int rowNum){
		return driver.findElement(By.xpath("//div[@id='rankings']/div[2]/a["+rowNum+"]/div[5]"));
	}
	
	private WebElement currPairLink (String firstCurr, String secondCurr){
		return driver.findElement(By.xpath("//a[@href='/markets/kraken/"+firstCurr.toLowerCase()+"/"+secondCurr.toLowerCase()+"']"));
	}
	
	
	// **** Methods ****
	
	public MarketsPage(WebDriver driver) {
		super(driver);
	}
	
	public void expandQuotesDropdown(){
		quotesDropdown.click();
	}
	
	public void typeQuotesTextbox(String currency){
		quotesTextbox.sendKeys(currency);
	}
	
	public void quoteSelect(String currency){
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@id='rankingsMenuQuotes']//div[@class='search-menu-items'")));
		dropdown.selectByVisibleText(currency);
	}
	
	public void clickCurrencyPair(String firstCurr, String secondCurr){
		currPairLink(firstCurr, secondCurr).click();
	}
	
	public String getTradingPair(int rowNumber){
		return tradingPair(rowNumber).getText();
	}
	
	public String getPrice(int rowNumber){
		return tablePrice(rowNumber).getText();
	}
	
	public int getTableCount(){
		return driver.findElements(By.xpath("//div[@id='rankings']/div[2]/a")).size();
	}


}