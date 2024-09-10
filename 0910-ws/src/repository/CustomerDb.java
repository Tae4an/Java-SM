package repository;

import dto.Customer;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

public class CustomerDb implements Db<String, Customer> {

    @Override
    public void insert(Customer customer) throws  Exception {
        System.out.println("Insert customer" + customer .getName());
    }

    @Override
    public void update(Customer customer) throws  Exception {
        System.out.println("Update customer" + customer.getName());
    }

    @Override
    public void delete(String s) throws  Exception {
        System.out.println("Delete customer" + s);
    }

    @Override
    public Customer select(String s) throws  Exception {
        return new Customer(s,"pw", "최태산");
    }

    @Override
    public List<Customer> select() throws  Exception {
        List<Customer> customers;
        customers = new ArrayList<>();
        customers.add(new Customer("111","pw","장태산"));
        customers.add(new Customer("222","pw","김태산"));
        customers.add(new Customer("333","pw","박태산"));
        customers.add(new Customer("444","pw","이태산"));
        return customers;
    }

    @Override
    public List<Customer> searchByName(String name) throws Exception {
        List<Customer> customers;
        customers = new ArrayList<>();
        customers.add(new Customer("111","pw","김태산"));
        customers.add(new Customer("222","pw","김재환"));
        customers.add(new Customer("333","pw","김시원"));
        customers.add(new Customer("444","pw","김태환"));
        return customers;
    }
}
