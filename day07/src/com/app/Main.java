package com.app;

import com.db.*;

public class Main {
    public static void main(String[] args) {
        Db customerDb= new CustomerDb();
        Customer customer = new Customer("id01","ped01","taesan");
        customerDb.insert(customer);
        customerDb.update(customer);
        customerDb.delete(customer.getId());

        Db itemDb = new ItemDb();
        Item item = new Item(100, "바지", 1000);

        itemDb.insert(item);
        itemDb.update(item);
        itemDb.delete(item.getId());
    }
}
