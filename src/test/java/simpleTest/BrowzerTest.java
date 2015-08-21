package simpleTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowzerTest {

	@Test
	public void search_in_google() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("abc.xyz");
		element.submit();
		WebElement webel = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//cite")));
		driver.close();
		doTest("https://abc.xyz/", webel.getText());
	}

	private void doTest(String expectedLink, String actualLink) {
		assertEquals(expectedLink, actualLink);
	}

}
