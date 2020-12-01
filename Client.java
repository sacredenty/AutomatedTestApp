
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


import org.json.JSONObject;


public class Client {
	public WebDriver driver = new FirefoxDriver();
    public String baseUrl;
    public String value;
    private String value1;
    private String value2;
    private String value3;
    public String keys;
    public int sleep = 2000;
    public int index;
    
    // Selenium related functions
    
	public void findElementInput(String baseUrl, String keys) throws InterruptedException {
		//
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ChrisOffice\\Downloads\\geckodriver.exe");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement query = driver.findElement(By.cssSelector("input"));
		query.sendKeys(keys);
		//System.out.println("done submitting...");
		Thread.sleep(sleep);
	}
	
	public void findElementSelectIndex(int index) throws InterruptedException {
		WebElement options = driver.findElement(By.cssSelector("select"));
		options.click();
		Thread.sleep(1000);
		Select dropdownOptions = new Select(driver.findElement(By.cssSelector("select")));
		dropdownOptions.selectByIndex(index);
		Thread.sleep(3000);
	}
	
	public void findElementButtonClick() throws InterruptedException {
		WebElement submit = driver.findElement(By.cssSelector("button"));
		submit.click();
		Thread.sleep(1000);
	}
	
	public void findElementButtonClickTwice() throws InterruptedException {
		WebElement submit = driver.findElement(By.cssSelector("button"));
		submit.click();
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(1000);
	}
	public void findElementFillForm(String stName, String lstName, String strt, String dob) throws InterruptedException {
		WebElement firstName = driver.findElement(By.name("borrowerFirstName"));
		firstName.sendKeys(stName);
		WebElement lastName = driver.findElement(By.name("borrowerLastName"));
		lastName.sendKeys(lstName);
		WebElement street = driver.findElement(By.name("borrowerStreet"));
		street.sendKeys(strt);
		Thread.sleep(3000);
		WebElement streetDropdown = driver.findElement(By.className("geosuggest__item"));
		streetDropdown.click();
		Thread.sleep(1000);
		WebElement borrowerDateOfBirth = driver.findElement(By.name("borrowerDateOfBirth"));
		borrowerDateOfBirth.sendKeys(dob);

	}
	
	public void findElementBorrowingInfo(String income, String additonalIncome) throws InterruptedException {
		WebElement borrowerIncome = driver.findElement(By.name("borrowerIncome"));
		borrowerIncome.sendKeys(income);
		
		WebElement borrowerAdditionalIncome = driver.findElement(By.name("borrowerAdditionalIncome"));
		borrowerAdditionalIncome.sendKeys(additonalIncome);
		Thread.sleep(1000);

	}
	public void findElementFillUsername(String email, String pass) throws InterruptedException {
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(email);
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
		Thread.sleep(1000);
		password.click();

	}
	public void findElementSelectCheckbox() throws InterruptedException {
		WebElement selectcheckbox = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div/label/div[1]"));
		selectcheckbox.click();
		Thread.sleep(1000);

	}
	
	public String [] findStoreVariousAmounts() throws InterruptedException {
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
		String values [] = new String [4];
		values [0] = value;
		values [1] = value1;
		values [2] = value2;
		values [3] = value3;
		return values;

	}
	public void signout() throws InterruptedException {
		WebElement clickMenu = driver.findElement(By.cssSelector("label.header-nav__toggle:nth-child(2)"));
		clickMenu.click();
		Thread.sleep(1000);
		
		WebElement signOut = driver.findElement(By.cssSelector("li.header-nav-menu__item:nth-child(2) > a:nth-child(1)"));
		signOut.click();
		Thread.sleep(1000);
	}
	
	public void login(String baseUrl, String emailAddy, String passWord) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ChrisOffice\\Downloads\\geckodriver.exe");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement query = driver.findElement(By.name("username"));
		query.sendKeys(emailAddy);
		System.out.println("done submitting...");
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passWord);
		Thread.sleep(2000);
	}
	
	public String validateUrl() throws InterruptedException {
		String URL= driver.getCurrentUrl();
		return URL;
	} 
	
	public String [] validateText() throws InterruptedException {
		
		WebElement textFieldElement = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2]"));
		String newValue = textFieldElement.getText();
		System.out.println(newValue);
		
		WebElement textFieldElement1 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div/span"));
		String newValue1 = textFieldElement1.getText();
		System.out.println(newValue1);
		
		WebElement textFieldElement2 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]"));
		String newValue2 = textFieldElement2.getText();
		System.out.println(newValue2);
		
		WebElement textFieldElement3 = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div"));
		String newValue3 = textFieldElement3.getText();
		System.out.println(newValue3);
		String newValues [] = new String [4];
		newValues [0] = newValue;
		newValues [1] = newValue1;
		newValues [2] = newValue2;
		newValues [3] = newValue3;
		return newValues;
	} 

	// HTTP api related function(s)
	
	public JSONObject httpConnect(String baseUrl, String byteOutArray) throws InterruptedException, IOException {
		try {
		URL url = new URL(baseUrl);
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)con;
		http.setRequestMethod("POST"); 
		http.setDoOutput(true);
		
		byte[] out = byteOutArray.getBytes(StandardCharsets.UTF_8);
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
		   return jsonObj;
		}catch (HttpRetryException e) {
			System.out.println(e);
			JSONObject jsonObj = new JSONObject(e);
			return jsonObj;
		}
		finally {}
		
	
}}
