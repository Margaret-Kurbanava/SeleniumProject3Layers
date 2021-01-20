package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.util.Set;

public class WindowManager extends TestBase {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

   /* public WindowManager(WebDriver driver){

        this.driver = driver;
        navigate = driver.navigate();
    }*/



    public WindowManager(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        navigate = driver.navigate();
    }


    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }


     //switch To another tab using tab Title
        public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for(String window : windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }


    //get Handle of the current window
    public String getCurrentWindowHandle(){

        String originalWindow = driver.getWindowHandle();
        return originalWindow;
    }


    //get Handle of all opened windows
    public Set<String> getExistingWindowsHandles(){

        Set <String>existingWindows = driver.getWindowHandles();
        return existingWindows;
    }


    //switch To a new window (a window that is missing in existing Windows Set)
    public void switchToWindowOtherThanExisting(Set <String> existingWindows){
        String newWindow = wait.until(anyWindowOtherThan(existingWindows));
        driver.switchTo().window(newWindow);

    }


    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }


    // close Window
    public void closeWindow(){
        driver.close();
    }


   //navigate to Window by Handle
    public void navigateToWindow(String handle){

    driver.switchTo().window(handle);

    }



}