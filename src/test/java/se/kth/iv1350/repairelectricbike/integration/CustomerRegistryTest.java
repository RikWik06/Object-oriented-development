package se.kth.iv1350.repairelectricbike.integration;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.util.LogHandler;

public class CustomerRegistryTest {
    private CustomerRegistry customerRegistry;
    private LogHandler logHandler;

    @BeforeEach
    public void setup() throws IOException{
        logHandler = new LogHandler();
        customerRegistry = new CustomerRegistry(logHandler);
    }

    @AfterEach
    public void tearDown(){
        customerRegistry = null;
    }

    @Test
    public void testFindCustomerThatIsNotInRegistry(){
        CustomerDTO customer = new CustomerDTO("Lisa", 1,"lisa@gmail.com", "Volvo", "The Super Speed-3000","DR31");
        customerRegistry.addCustomer(customer);
        customerRegistry.findCustomer(2);
    }
}
