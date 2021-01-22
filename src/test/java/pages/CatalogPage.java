package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class CatalogPage extends Page {

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    private String catalogPage = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";

 /*   @FindBy(css= "img + a[href*=\"doc=edit_product\"]")
    public List<WebElement> products;*/

 public By product = By.cssSelector("img + a[href*=\"doc=edit_product\"]");




    public void openCatalogPage(){
        driver.get(catalogPage);
    }








}
