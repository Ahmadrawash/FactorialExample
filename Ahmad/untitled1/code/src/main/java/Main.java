package src.main.java;

import org.junit.Before;
import org.junit.Test;

//both junit and Hamcrest are needed for testing

public class Main {
    static Customers cust;

    public static void main(String args[])
    {
//        cust = new Customers();
//        cust.AddCustomer("Ali");
//        cust.AddCustomer("Ahmad");
//        System.out.println(cust.getCount());
//        System.out.println(cust.PrintAll());
    }

    @Before
    public void Initialize()
    {
        cust = new Customers();
        cust.AddCustomer("Ali");
        cust.AddCustomer("Ahmad");
        //cust.AddCustomer("Mohammad");
    }

    @Test
    public void TestAdding()
    {
         org.junit.Assert.assertEquals(2, cust.getCount());
    }

    @Test
    public void TestArrays()
    {
        int[] a = {2, 3, 10};
        int[] b = {2, 3, 10};
        org.junit.Assert.assertArrayEquals(a, b);
    }

}
