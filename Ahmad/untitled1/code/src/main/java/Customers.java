package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    public Customers() {
        this.customers = new ArrayList<String>();
    }

    public List<String> getCustomers() {
        return customers;
    }

    public List<String> customers;

    public int getCount() {
        return customers.size();
    }

    public int count;

    public boolean AddCustomer(String name)
    {
        return customers.add(name);
    }

    public String PrintAll()
    {
        String output = "";
        for (String c: customers) {
            output += c + ", ";
        }
        return output;
    }
}
