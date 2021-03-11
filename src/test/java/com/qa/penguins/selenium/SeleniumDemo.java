package com.qa.penguins.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumDemo {

	@LocalServerPort
	private int port;

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver(options);
	}

	@Test
	void test() {
		this.driver.get("http://localhost:" + port);

		WebElement title = this.driver.findElement(By.xpath("/html/body/h1"));

		assertThat(title.getText()).isEqualTo("Penguins");
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
