
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


import org.json.JSONArray;
import org.json.JSONObject;

//import com.fasterxml.jackson.databind.ObjectMapper;



public class NewTest {
	private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    private String baseUrl3;
    private String value;
    private String value1;
    private String value2;
    private String value3;

    
	@BeforeTest
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ChrisOffice\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.credify.tech/phone/nonDMFunnel";
		baseUrl2 = "https://www.credify.tech/portal/login";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		baseUrl3 = "https://credapi.credify.tech/api/brportorch/v2/login";
	}
	//First part of take home programming challenge.
	@Test
  	public void webUiTest1() throws InterruptedException {
//	  Test description: Go through app flow and successfully submit for your loan
		driver.get(baseUrl);
		WebElement query = driver.findElement(By.cssSelector("input"));
		query.sendKeys("2000");
		System.out.println("done submitting...");
		Thread.sleep(1000);
	
		WebElement options = driver.findElement(By.cssSelector("select"));
		options.click();
		Thread.sleep(1000);
		Select dropdownOptions = new Select(driver.findElement(By.cssSelector("select")));
		dropdownOptions.selectByIndex(1);
		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.cssSelector("button"));
		submit.click();
		System.out.println("done clicking pay off credit cards");
		Thread.sleep(3000);
		WebElement firstName = driver.findElement(By.name("borrowerFirstName"));
		firstName.sendKeys("John");
		WebElement lastName = driver.findElement(By.name("borrowerLastName"));
		lastName.sendKeys("Smith");
		WebElement street = driver.findElement(By.name("borrowerStreet"));
		street.sendKeys("123 main street");
		Thread.sleep(3000);
		WebElement streetDropdown = driver.findElement(By.className("geosuggest__item"));
		streetDropdown.click();
		Thread.sleep(1000);
		WebElement borrowerDateOfBirth = driver.findElement(By.name("borrowerDateOfBirth"));
		borrowerDateOfBirth.sendKeys("02051975");
		
		WebElement letsgo = driver.findElement(By.cssSelector("button"));
		letsgo.click();
		WebElement borrowerIncome = driver.findElement(By.name("borrowerIncome"));
		borrowerIncome.sendKeys("125000");
		
		WebElement borrowerAdditionalIncome = driver.findElement(By.name("borrowerAdditionalIncome"));
		borrowerAdditionalIncome.sendKeys("7000");
		
		Thread.sleep(2000);
		WebElement letscontinue = driver.findElement(By.cssSelector("button"));
		letscontinue.click();
		Thread.sleep(1000);
		letscontinue.click();
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("johndoe@email.com");
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Pass1234");
		Thread.sleep(1000);
		password.click();
		Thread.sleep(3000);
		//checkbox
		WebElement selectcheckbox = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div/label/div[1]"));
		selectcheckbox.click();
		Thread.sleep(1000);
		
		
		WebElement createAccount = driver.findElement(By.cssSelector("button"));
		createAccount.click();
		Thread.sleep(1000);
		System.out.println("second click mang");
		Thread.sleep(10000);
		
		//store various amounts
		
		WebElement textFieldElement = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2]"));
		value = textFieldElement.getText();
		System.out.println(value);
		
		WebElement textFieldElement1 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div/span"));
		value1 = textFieldElement1.getText();
		System.out.println(value1);
		
		WebElement textFieldElement2 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]"));
		value2 = textFieldElement2.getText();
		System.out.println(value2);
		
		WebElement textFieldElement3 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div"));
		value3 = textFieldElement3.getText();
		System.out.println(value3);
		
		
//		//logout
		WebElement clickMenu = driver.findElement(By.cssSelector("label.header-nav__toggle:nth-child(2)"));
		clickMenu.click();
		Thread.sleep(1000);
		
		WebElement signOut = driver.findElement(By.cssSelector("li.header-nav-menu__item:nth-child(2) > a:nth-child(1)"));
		signOut.click();
		Thread.sleep(1000);
		
		
	}
	@Test
	public void webUiTest2() throws InterruptedException {
			//Login to webui and validate stored info 
			driver.get(baseUrl2);
			WebElement query = driver.findElement(By.name("username"));
			query.sendKeys("johndoe@email.com");
			System.out.println("done submitting...");
			Thread.sleep(1000);
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("Pass1234");
			Thread.sleep(2000);
			WebElement options = driver.findElement(By.cssSelector(".sc-iJCRLp"));
			options.click();
			Thread.sleep(5000);
			//assert on offer-page
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://www.credify.tech/funnel/offer-page" );
			{
			Thread.sleep(5000);
			
			// validate text
			WebElement textFieldElement = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2]"));
			String newValue = textFieldElement.getText();
			System.out.println(value);
			Assert.assertEquals(newValue, value);
			
			WebElement textFieldElement1 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div/span"));
			String newValue1 = textFieldElement1.getText();
			System.out.println(newValue1);
			Assert.assertEquals(newValue1, value1);
			
			WebElement textFieldElement2 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]"));
			String newValue2 = textFieldElement2.getText();
			System.out.println(newValue2);
			Assert.assertEquals(newValue2, value2);
			
			WebElement textFieldElement3 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div"));
			String newValue3 = textFieldElement3.getText();
			System.out.println(newValue3);
			Assert.assertEquals(newValue3, value3);
			
			driver.close();
          }
		}
	// 2nd part of take home programming challenge
	@Test
	public void apiTest1() throws IOException, InterruptedException {
		//send http api calls
		
		URL url = new URL(baseUrl3);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); 
		http.setDoOutput(true);
		
		
		
		byte[] out = "{\"username\":\"coding.challenge.login@upgrade.com\",\"password\":\"On$3XcgsW#9q\"}".getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		UUID uuid = UUID.randomUUID();
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("x-cf-source-id", "coding-challenge");
		http.setRequestProperty("x-cf-corr-id", uuid.toString());
		http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		    //System.out.println(out);
		}
		  InputStream response = http.getInputStream();
		  System.out.println(response);
		  int code = http.getResponseCode();
		  System.out.println(code);
		  //Assert response code = 200
		  Assert.assertEquals(code, 200);
		  // convert inputSteam to string
		
		  StringBuilder textBuilder = new StringBuilder();
		    try (Reader reader = new BufferedReader(new InputStreamReader
		      (response, Charset.forName(StandardCharsets.UTF_8.name())))) {
		        int c = 0;
		        while ((c = reader.read()) != -1) {
		            textBuilder.append((char) c);
		        }
		    }
		   System.out.println(textBuilder.toString());

		   
		   String jsonResponse = textBuilder.toString();

		   JSONObject jsonObj = new JSONObject(jsonResponse);

		   System.out.println(jsonObj);

		   JSONArray jsonChildArray = jsonObj.getJSONArray("loansInReview");
		   System.out.println(jsonChildArray);
		   JSONObject JsonChildObj = jsonChildArray.getJSONObject(0);
		
		   String productType = JsonChildObj.optString("productType");
			
			Assert.assertEquals(JsonChildObj.has("productType"), true);
			Assert.assertEquals(productType, "PERSONAL_LOAN");
			
			http.disconnect();
		
	}
	@Test
	public void apiTest2() throws IOException, InterruptedException {
		//send http api calls with an invalid username - should get 401 response code
		
		URL url = new URL(baseUrl3);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); 
		http.setDoOutput(true);
		
		
		byte[] out = "{\"username\":\"fakeusername\",\"password\":\"On$3XcgsW#9q\"}".getBytes(StandardCharsets.UTF_8);
		int length = out.length;
		UUID uuid = UUID.randomUUID();
		http.setFixedLengthStreamingMode(length);
		http.setRequestProperty("x-cf-source-id", "coding-challenge");
		http.setRequestProperty("x-cf-corr-id", uuid.toString());
		http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		    os.write(out);
		    //System.out.println(out);
		}
		try {
		  InputStream response = http.getInputStream();
		  System.out.println(response);
		  int code = http.getResponseCode();
		  System.out.println(code);
		  //Assert response code = 401
		  Assert.assertEquals(code, 401);
		     
		  http.disconnect();
		} catch (Exception e) {
			// We catch the exception here and assert that our http failed because of the bad username 
			Assert.assertEquals(e.toString(),"java.net.HttpRetryException: cannot retry due to server authentication, in streaming mode");
		}
	}
}
	


