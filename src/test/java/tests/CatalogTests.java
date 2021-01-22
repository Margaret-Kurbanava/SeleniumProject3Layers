package tests;

import org.testng.annotations.Test;
import pages.CatalogPage;

public class CatalogTests extends TestBase {




    @Test
    public void checkProducts(){
        app.loginToAdmin();
        app.checkProducts();



    }
























}
