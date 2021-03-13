package com.qa.penguins.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the front end in [src/main/resources/static] and
																// hosts it on a random port
@Sql(scripts = { "classpath:penguin-schema.sql",
		"classpath:penguin-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) // resets db between tests
																							// -> means that only ONE
																							// penguin rendered to page
																							// at start of test
@ActiveProfiles("test") // uses h2db
public class SeleniumDemo {

	@LocalServerPort // fetches the random port
	private int port;

	private RemoteWebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true); // turns off the chrome window (great when tests are FINISHED)
		this.driver = new ChromeDriver(options);

		this.driver.manage().window().maximize(); // maximizes window

		this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // will wait two seconds for EVERY ELEMENT

		System.setProperty("webdriver.chrome.driver", "C:\\Shared\\chromedriver.exe"); // loads chromedriver from folder

		this.wait = new WebDriverWait(driver, 5); // set up explicit wait -> up to 5 seconds ONLY WHEN USED
	}

	@Test
	void test() {
		this.driver.get("http://localhost:" + port); // loads front-end on random port

		WebElement title = this.driver.findElement(By.xpath("/html/body/h1")); // gets title

		assertThat(title.getText()).isEqualTo("Penguins"); // checks title has correct text
	}

	@Test
	void testCreate() {
		this.driver.get("http://localhost:" + port);

		final String name = "pingu"; // created a variable due to string being used in BOTH sendKeys() and
										// assertEquals()
		final String age = "22";
		final String tuxedoSize = "44";

		WebElement penguinName = this.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("penguinName")));
		penguinName.sendKeys(name);

		WebElement penguinAge = this.driver.findElementById("penguinAge");
		penguinAge.sendKeys(age);

		WebElement penguinTuxedoSize = this.driver.findElementById("tuxedoSize");
		penguinTuxedoSize.sendKeys(tuxedoSize);
		penguinTuxedoSize.sendKeys(Keys.ENTER);

		// uses the WebDriverWait to wait upto 5 seconds for element to appear
		WebElement createdPenguinName = this.wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div[2]/div/div[1]/h5")));

		WebElement penguinText = this.driver.findElementByXPath("//*[@id=\"output\"]/div[2]/div/div[1]/p");

		Assertions.assertEquals(name, createdPenguinName.getText());

		Assertions.assertTrue(penguinText.getText().contains("Age: " + age));
		Assertions.assertTrue(penguinText.getText().contains("Tuxedo Size: " + tuxedoSize));
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
