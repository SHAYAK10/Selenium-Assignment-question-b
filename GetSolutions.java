package com.main;

import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.base.Base;
import com.opencsv.CSVWriter;

public class GetSolutions extends Base{

	public static void main(String[] args) throws Exception {
		setBrowser("chrome", "https://stackoverflow.com");  
		driver.findElement(By.xpath("/html/body/header/div/form/div/input")).sendKeys("java.lang.ArrayIndexOutOfBoundsException" + Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[5]/div/button[1]")).click();
		Thread.sleep(2000);
		
		Answers.add(Header);
		for(int i = 1; i <= 10 ; i++) {
			Heading = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/h3/a"));
			Answer = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[2]/div[1]"));
			Views = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[3]/span[1]"));
			Votes = driver.findElement(By
					.xpath("/html/body/div[4]/div[2]/div[1]/div[4]/div/div[" + i + "]/div[1]/div[1]/span[1]"));
			
			Answers.add(new String[] {
					Heading.getText(),
					Answer.getText(),
					Views.getText(),
					Votes.getText()
			}); 
			
		}
		
		//Heading
		///html/body/div[3]/div[2]/div[1]/div[4]/div/div[1]/div[2]/h3/a
		///html/body/div[3]/div[2]/div[1]/div[4]/div/div[2]/div[2]/h3/a

		writernew = new CSVWriter(new FileWriter("data.csv"));
		writernew.writeAll(Answers);
		writernew.close();
		
		
	}

	
}
