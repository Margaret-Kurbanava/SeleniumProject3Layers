package tests;

//import com.tngtech.java.junit.dataprovider.DataProvider;
import org.testng.annotations.DataProvider;
import testData.Customer;


public class DataProviders {

    @DataProvider(name = "customer-provider")
    public static Object[][] validCustomers() {
        return new Object[][] {
                { Customer.newEntity()
                        .withFirstname("Adam").withLastname("Smith").withPhone("+0123456789")
                        .withAddress("Hidden Place").withPostcode("12345").withCity("New City")
                        .withCountry("US").withZone("KS")
                        .withEmail("adam"+System.currentTimeMillis()+"@smith.me")
                        .withPassword("qwerty").build() },
                /* ... */
        };
    }

}
