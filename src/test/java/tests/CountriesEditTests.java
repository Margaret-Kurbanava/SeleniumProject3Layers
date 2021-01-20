package tests;

import org.testng.annotations.Test;

public class CountriesEditTests extends TestBase{



    @Test
    public void checkExternalLinks(){
        app.loginToAdmin();
        app.openCountryEditMode();
       app.checkExternalLinks();
    }


}
