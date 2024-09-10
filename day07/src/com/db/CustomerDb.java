package com.db;

public class CustomerDb implements Db{
    @Override
    public void insert(Object object) {
        Customer c = (Customer) object;
        System.out.println(c.getName());
        System.out.println("Insert Customer"+object);
    }

    @Override
    public void update(Object object) {
        System.out.println("Update Customer"+object);
    }

    @Override
    public void delete(Object object) {
        System.out.println("Delete Customer"+object);
    }

    @Override
    public void search(Object object) {
        System.out.println("Search Customer"+object);
    }
}
