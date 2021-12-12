import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
public class DataDrivenDemo {

		public WebDriver driver;
		@Test(dataprovider ="testdata")
		public void DemoDD(String username,String password) {
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class='radius']")).click();
			//driver.findElement(By.cssSelector(".radius")).click();
			
			Assert.assertTrue(driver.findElement(By.className("subheader")).isDisplayed(),"Invalid Credentials");
		}
		
		@BeforeMethod
		
		public void beforeMethod() {
			
			System.setProperty("webdriver.driver.chrome","C:\\Users\\Srishti\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/login");
			
		}
		
		@AfterMethod
		public void afterMethod() {
			driver.quit();
		}
		
		@DataProvider(name="testdata")
		public Object[][] TestDataSample(){
			
			ReadExcelFile gettestdata = new ReadExcelFile("C:\\Users\\Srishti\\Downloads\\LoginCredentials.xlsx");
			
			int rows = gettestdata.getRowCount(0);
			Object[][] creds = new Object[rows][2];
			
			for(int i=0; i<rows;i++)
			{
				creds[i][0]= gettestdata.getData(0,i,0);
				creds[i][1]= gettestdata.getData(0,i,1);
			}
			
			return creds;
			
		}
		
	}

