package tests;

import org.testng.annotations.Test;
import pages.CatalogPage;

public class CatalogTests extends TestBase {




    @Test
    public void checkProducts(){
        app.loginToAdmin();
        //go through products, get browser logs, fail test if there is something in browser logs
        app.checkProducts();



    }
























}
