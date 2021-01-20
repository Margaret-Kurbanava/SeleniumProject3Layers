package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminPanelLoginPage;
import pages.CountriesPage;
import pages.CustomerListPage;
import pages.RegistrationPage;
import testData.Customer;
import tests.TestBase;
import utils.WindowManager;


import java.util.Set;

public class Application {

    private WebDriver driver;


    private RegistrationPage registrationPage;
    private AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;
    private CountriesPage countriesPage;
    private WindowManager windowManager;

    public Application() {

        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
        countriesPage = new CountriesPage(driver);
        windowManager = new WindowManager(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.address1Input.sendKeys(customer.getAddress());
        registrationPage.postcodeInput.sendKeys(customer.getPostcode());
        registrationPage.cityInput.sendKeys(customer.getCity());
        registrationPage.selectCountry(customer.getCountry());
        registrationPage.selectZone(customer.getZone());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.phoneInput.sendKeys(customer.getPhone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
        registrationPage.createAccountButton.click();
    }

    public Set<String> getCustomerIds() {
        if (adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
        }

        return customerListPage.open().getCustomerIds();
    }


    public void loginToAdmin() {
        adminPanelLoginPage.open().enterUsername("admin").enterPassword("admin").submitLogin();
    }


    public void openCountryEditMode() {
        countriesPage.open();
        countriesPage.firstCountry.click();
    }



    public void checkExternalLinks() {

        countriesPage.externalLinks.forEach((link) -> {

            //get Handle of the current window
            String originalWindowHandle = windowManager.getCurrentWindowHandle();
            //get Handle of all opened windows
            Set<String> existingWindowsHandles = windowManager.getExistingWindowsHandles();
            //open external link
            link.click();
            //switch To a new window (a window that is missing in existing Windows Set)
            windowManager.switchToWindowOtherThanExisting(existingWindowsHandles);
            // close Window
            windowManager.closeWindow();
            //navigate to original Window by Handle
            windowManager.navigateToWindow(originalWindowHandle);


        });


    }


}