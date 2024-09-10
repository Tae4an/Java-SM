package app;

import dto.Customer;
import dto.Item;
import repository.CustomerDb;
import repository.ItemDb;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        testCustomerDb();
        System.out.println("\n----------------------------\n");
        testItemDb();
    }

    public static void testCustomerDb() {
        System.out.println("CustomerDb:");
        CustomerDb customerDb = new CustomerDb();

        try {
            // Insert
            Customer newCustomer = new Customer("1234", "password", "최태산");
            System.out.println("-------------------------------------------------------------------------");
            customerDb.insert(newCustomer);

            // Select
            System.out.println("-------------------------------------------------------------------------");
            Customer selectedCustomer = customerDb.select("555");
            System.out.println("Selected customer: " + selectedCustomer);

            // Update
            System.out.println("-------------------------------------------------------------------------");
            selectedCustomer.setName("업데이트된 고객");
            customerDb.update(selectedCustomer);

            // Select all
            List<Customer> allCustomers = customerDb.select();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("All customers:");
            for (Customer customer : allCustomers) {
                System.out.println(customer);
            }

            // Search by name
            List<Customer> searchResults = customerDb.searchByName("김태산");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Customers with name '김태산':");
            for (Customer customer : searchResults) {
                System.out.println(customer);
            }

            // Delete
            System.out.println("-------------------------------------------------------------------------");
            customerDb.delete("1234");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testItemDb() {
        System.out.println("ItemDb:");
        System.out.println("-------------------------------------------------------------------------");
        ItemDb itemDb = new ItemDb();

        try {
            // Insert
            Item newItem = new Item(200, "닭가슴 살", 1900,"닭 가슴살 사진");
            itemDb.insert(newItem);

            // Select
            System.out.println("-------------------------------------------------------------------------");
            Item selectedItem = itemDb.select(200);
            System.out.println("Selected item: " + selectedItem);

            // Update
            System.out.println("-------------------------------------------------------------------------");
            selectedItem.setPrice(16000);
            itemDb.update(selectedItem);

            // Select all
            List<Item> allItems = itemDb.select();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("All items:");
            for (Item item : allItems) {
                System.out.println(item);
            }

            // Delete
            System.out.println("-------------------------------------------------------------------------");
            itemDb.delete(200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}