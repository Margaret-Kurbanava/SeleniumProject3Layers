package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CountriesPage extends Page {

    public CountriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css="form[name='countries_form'] a:not([title=\"Edit\"])")
    public WebElement firstCountry;


    @FindBy(css = ".fa-external-link")
    public List<WebElement> externalLinks;

    //private By countryLink = By.cssSelector("form[name='countries_form'] a:not([title=\"Edit\"])");



    public void open() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
     }





    }















