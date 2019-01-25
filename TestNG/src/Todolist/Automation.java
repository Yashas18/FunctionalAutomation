package Todolist;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Automation {
	
	public WebDriver driver;
	
	public String appURL = "http://localhost/dotdash-project/index.php";
	public String taskName1 = "Learn Skiing";
	public String taskNameupdate = "and Skating";
	public String catgName1 = "Sports";
	public String color = "Green";
	public String dateVal = "15";
	public String monthVal = "Mar";
	public String yearVal = "2019";

	@BeforeTest
	public void openwebpage() {
		System.setProperty("webdriver.gecko.driver","C://Yashaswi//Dotdash//Seleniumdrivers//geckodriver-v0.23.0-win64//geckodriver.exe");
		   
		driver = new FirefoxDriver();
		 
		driver.get(appURL);
		driver.manage().window().maximize();
	}
	
  @Test(priority=2)
//Adding category
 
  public void Addcategory() {
								
	  	driver.findElement(By.xpath("//input[@name='categorydata']")).sendKeys(catgName1);
			
			Select sel5 = new Select(driver.findElement(By.xpath("//select[@title='Select default color for this category']")));
			sel5.selectByVisibleText(color);
			
			driver.findElement(By.xpath("//input[@value='Add category']")).click();
			
			String Category = driver.findElement(By.xpath("//span[contains(text(),'" + catgName1 + "')]")).getText();
						Assert.assertEquals(Category, catgName1);
			
  }
  
  
  @Test(priority=3)
  //Creating new Item
  
		 public void Createitem() {
	 
	  	  
	 
	  driver.findElement(By.xpath("//input[@name='data']")).sendKeys(taskName1);
		
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@name='category']")));
		sel1.selectByVisibleText(catgName1);
		
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@name='due_day']")));
		sel2.selectByVisibleText(dateVal);
		
		Select sel3 = new Select(driver.findElement(By.xpath("//select[@name='due_month']")));
		sel3.selectByVisibleText(monthVal);
		
		Select sel4 = new Select(driver.findElement(By.xpath("//select[@name='due_year']")));
		sel4.selectByVisibleText(yearVal);

		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		String item = driver.findElement(By.xpath("//span[contains(text(),'" + taskName1 +"')]")).getText();
			
		Assert.assertEquals(item, taskName1);
	
  }
  
  @Test(priority=4)
  //Edit added item
  
  public void Editaddeditem() {
	  
	 // String line = driver.findElement(By.xpath("//a[contains(text(),'0')]")).getText();
	  driver.findElement(By.xpath("//a[contains(text(),'0')]")).click();
	  driver.findElement(By.xpath("//input[@value='" + taskName1 + "']")).sendKeys(taskNameupdate);
	  driver.findElement(By.xpath("//input[@value='Update']")).click();
	 
	  
	String item1 = driver.findElement(By.xpath("//span[contains(text(),'" + taskName1 + ""+ taskNameupdate + "')]")).getText();
		
		Assert.assertEquals(item1, taskName1+taskNameupdate);
	  
  }
 
  
  @Test(priority=5)
  
  //Complete created task item
  
  public void Completeitem() {
	  
	  driver.findElement(By.xpath("//input[@name='todo[0]']")).click();
	  driver.findElement(By.xpath("//input[@value='Complete']")).click();
	 
	  
	   
	  String item2 = driver.findElement(By.xpath("//strike[contains(text(),'" + taskName1 +""+ taskNameupdate + "')]")).getText();
	  
	  Assert.assertEquals(item2, taskName1+taskNameupdate);	  
	  
  }
  

 
		 @Test(priority=6)
		
		//Deleting item added
		public void Deleteitem() {
			
			driver.findElement(By.xpath("//input[@name='todo[0]']")).click();
		
		   driver.findElement(By.xpath("//input[@value='Remove']")).click();
		   		   
		   Boolean item3 =driver.getPageSource().contains("" + taskName1 +" "+ taskNameupdate +" ");
		
		 if (item3==true)
			  
		{System.out.println("Deleting an item is failed");
		
		} else 
		{
			 System.out.println("Deleting an item is Successful");
			    
		}
		 }
		 
		 
		 @Test(priority=7)
		 
		 //DeleteCategory
		 
		 public void Deletecategory() {
			 
			 driver.findElement(By.xpath("//span[contains(text(),'" + catgName1 + "')]")).click();
					 
			 driver.findElement(By.xpath("//a[contains(text(),'Yes')]")).click();
			 
			  Boolean item3 =driver.getPageSource().contains("catgName1");
				
				 if (item3==true)
					  
				{System.out.println("Deleting a category is failed");
				
				} else 
				{
					 System.out.println("Deleting a category is Successful");
					    
				}
			 
		 }
		 
	 @Test(priority=1)
		 //Toggle all functionality
		 
		 public void Togglefunctionality () {
			 
			 driver.findElement(By.xpath("//input[@value='on']")).click();
			 driver.findElement(By.xpath("//input[@value='Remove']")).click();
			 
			 			
					   
  {
  }
  
		 }
@AfterTest


public void quitDriver(){
    driver.quit();
}       

}


