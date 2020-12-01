import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;


public class NewTest {
	public WebDriver driver;
    public String baseUrl;
    private String baseUrl2;
    private String baseUrl3;
    public String keys;
    public int index;
    public String stName;
    public String lstName;
    public String strt;
    public String dob;
    public String income;
    public String additonalIncome;
    public String email;
    public String pass;
    public String emailAddy;
    public String passWord;
    protected static String [] Values;
    public String byteOutArray;
    
    
	@BeforeTest
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ChrisOffice\\Downloads\\geckodriver.exe");
		baseUrl = "https://www.credify.tech/phone/nonDMFunnel";
		baseUrl2 = "https://www.credify.tech/portal/login";
		baseUrl3 = "https://credapi.credify.tech/api/brportorch/v2/login";
	}
	//First part of take home programming challenge.
	@Test(priority=1)
  	public void webUiTest1() throws InterruptedException {
		Client ob = new Client();
		ob.findElementInput(baseUrl,keys="2000");
		ob.findElementSelectIndex(index = 1);
		ob.findElementButtonClick();
		ob.findElementFillForm(stName = "John", lstName = "Smith", strt = "123 main street", dob = "01011975");;
		ob.findElementButtonClick();
		ob.findElementBorrowingInfo(income = "125000", additonalIncome = "7000");
		ob.findElementButtonClickTwice();
		ob.findElementFillUsername(email ="johndoe@email.com", pass = "Pass1234" );
		ob.findElementSelectCheckbox();
		ob.findElementButtonClick();
		Thread.sleep(6000);
		Values = ob.findStoreVariousAmounts();
	
		ob.signout();
		
	}
	@Test(priority=2)
	public void webUiTest2() throws InterruptedException {
			//Login to webui and validate stored info 
		Client ob = new Client();
		ob.login(baseUrl = baseUrl2, emailAddy = "johndoe@email.com", passWord = "Pass1234");
		ob.findElementButtonClick();
		Thread.sleep(6000);
		String url = ob.validateUrl();
		Assert.assertEquals(url, "https://www.credify.tech/funnel/offer-page" );
		String [] expectedValues = Values;
		String [] values = ob.validateText();
		System.out.println(expectedValues);
		System.out.println(values);
		Assert.assertEquals(values, expectedValues);

          }
		
	// 2nd part of take home programming challenge
	@Test(priority=3)
	public void httpTest1() throws IOException, InterruptedException {
		// send http api calls- validate correct productType
		Client ob = new Client();
		JSONObject jsonObj = ob.httpConnect(baseUrl = baseUrl3, byteOutArray = "{\"username\":\"coding.challenge.login@upgrade.com\",\"password\":\"On$3XcgsW#9q\"}");
		JSONArray jsonChildArray = jsonObj.getJSONArray("loansInReview");
		System.out.println(jsonChildArray);
		JSONObject JsonChildObj = jsonChildArray.getJSONObject(0);
		String productType = JsonChildObj.optString("productType");
		Assert.assertEquals(JsonChildObj.has("productType"), true);
		Assert.assertEquals(productType, "PERSONAL_LOAN");

	}
	@Test(priority=4)
	public void httpTest2() throws IOException, InterruptedException {
		//send http api calls with an invalid username - should get 401 response code
		Client ob = new Client();
		JSONObject jsonObj = ob.httpConnect(baseUrl = baseUrl3, byteOutArray = "{\"username\":\"badname@upgrade.com\",\"password\":\"On$3XcgsW#9q\"}");
		Assert.assertEquals(jsonObj.toString(), "{\"reason\":\"cannot retry due to server authentication, in streaming mode\"}");

	}
}
	



