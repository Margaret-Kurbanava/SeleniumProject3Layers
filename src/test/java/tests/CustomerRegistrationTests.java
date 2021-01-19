package tests;

//import com.tngtech.java.junit.dataprovider.DataProviderRunner;
//import com.tngtech.java.junit.dataprovider.UseDataProvider;




import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.Customer;

import java.util.Set;
import static org.junit.Assert.assertTrue;




//@RunWith(DataProviderRunner.class)
public class CustomerRegistrationTests extends TestBase {


    @Test(dataProviderClass = DataProviders.class, dataProvider = "customer-provider")
    //@UseDataProvider(value = "validCustomers", location = DataProviders.class)
    public void canRegisterCustomer(Customer customer) {
        Set<String> oldIds = app.getCustomerIds();

        app.registerNewCustomer(customer);

        Set<String> newIds = app.getCustomerIds();

        assertTrue(newIds.containsAll(oldIds));
        assertTrue(newIds.size() == oldIds.size() + 1);
    }


  }