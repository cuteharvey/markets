package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.MarketsPage;

public class MarketsTest extends BaseClass {
	
	/*
	 * Code Challenge: UI Automation Testing 
Sample automation code written in Java with Selenium WebDriver that can: 
1.	Select item from pulldown menu 
2.	Input text into a textbox
3.	Click button
4.	Click page link
5.	Select value from a table

	 * */

	@Test
	public void quotes(){
		// navigate to the market's page
		driver.get("https://trade.kraken.com/markets");
		MarketsPage marketsPage = new MarketsPage(driver);
		for (int rowNum = 1; rowNum < marketsPage.getTableCount()+1; rowNum ++)
		{
			// get the trading pair from the table
			System.out.println("Trading Pair: " + marketsPage.getTradingPair(rowNum));
			// get the price of the trading pair from the table
			System.out.println("Price: " + marketsPage.getPrice(rowNum));
			// verify the the price is greater than 0
			assertTrue(Double.parseDouble(marketsPage.getPrice(rowNum)) > 0);
		}
		//click the BTC/USD trading pair link
		marketsPage.clickCurrencyPair("BTC", "USD");
		//go back to the main market page
		driver.get("https://trade.kraken.com/markets");
		// the Quotes dropdown in my firefox doesn't expand. i have version 43.
		//expand the quotes dropdown
		marketsPage.expandQuotesDropdown();
		// type BTC to the quotes textbox
		marketsPage.typeQuotesTextbox("BTC");
		// select the BTC from the dropdown
		marketsPage.quoteSelect("BTC");
		

	}	
}
