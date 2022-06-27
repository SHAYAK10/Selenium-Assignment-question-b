package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.opencsv.CSVWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static List<String[]> Answers = new ArrayList<String[]>();
	public static String[] Header = { "Heading", "Answer", "Views", "Votes" };
	public static WebElement Heading, Answer, Views, Votes;
	public static CSVWriter writernew;
	public static JavascriptExecutor js;
	public Writer outputFile;

	public Base() {
		
		try {
			
			FileInputStream file1 = new FileInputStream("./src/main/java/com/config/config.properties");
			prop.load(file1);

		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}

		js = (JavascriptExecutor) driver;
//		writernew = new CSVWriter(outputFile);

		try {
			outputFile = new FileWriter("Data.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getProperty() {
		
	}

	// method for initialising the browser with the url
	public static void setBrowser(String browser, String url) {
		if (browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.toLowerCase().equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		} else if (browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			System.out.println("Browser not found.\n !!Please configure the Browser name.");
		}

		driver.get(url);
		driver.manage().window().maximize();
	}

}
