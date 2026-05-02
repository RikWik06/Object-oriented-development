package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration;

public class CustomerRegistry {
    public CustomerDTO[] registry;

    public void addCustomer(CustomerDTO[] customerRegistry, CustomerDTO customer){
        int index = 0;
        while (customerRegistry[index] != null)
            index++;
        customerRegistry[index] = customer;
    }

    public CustomerRegistry(CustomerDTO[] registry){
        this.registry = registry;
    }
}
