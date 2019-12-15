package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	private static WebDriver dr;
	public Dashboard(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(linkText="Welcome Admin")
	WebElement welcomeMsg;
	
	@FindBy(css=".menu a[class='firstLevelMenu']")
	List<WebElement> firstLevelMenu;
	
	@FindBy(css="menu_pim_viewPimModule")
	WebElement pim;
	
	@FindBy(css="menu_pim_viewEmployeeList")
	WebElement empList;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr")
	List<WebElement> tableData;
	
	public boolean successMsg() {
		boolean b=false;
		try {
			b=welcomeMsg.isDisplayed();
		}catch(Exception e) {}
		return b;
	}
	
	public List<String> getFirstLevelMenu(){
		List<String> list=new ArrayList<String>();
		for(WebElement e:firstLevelMenu) {
			list.add(e.getText());
		}
		return list;
	}
	public void clickOnPIM() {
		pim.click();
	}
	public void clickOnEmpList() {
		empList.click();
	}
	
	public List<String> getEmpID() {
		List<String> idList = new ArrayList<String>(); 
		int s=tableData.size();
		for(int i=1;i<=s;i++) 
		{
			String str = dr.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")).getText();
			idList.add(str);
		}
		return idList;
	}
	
	//table[@id='resultTable']/tbody/tr[1]/td[4]/a
	public List<String> getEmpFullName() {
		List<String> idList = new ArrayList<String>(); 
		int s=tableData.size();
		for(int i=1;i<=s;i++) 
		{
			String first = dr.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]/a")).getText();
			String last = dr.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[4]/a")).getText();
			idList.add(first+" "+last);
		}
		return idList;
	}
	public List<String> getEmpSuperVisorlName() {
		List<String> idList = new ArrayList<String>(); 
		int s=tableData.size();
		for(int i=1;i<=s;i++) 
		{
			String sup = dr.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[8]")).getText();
			idList.add(sup);
		}
		return idList;
	}
	}
