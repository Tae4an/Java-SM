package edu.sm;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemCRUD itemCRUD = new ItemCRUD();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Item Management System =====");
            System.out.println("1. Insert item");
            System.out.println("2. Search all items");
            System.out.println("3. Search for a specific item");
            System.out.println("4. Update item");
            System.out.println("5. Delete item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertItem(itemCRUD, scanner);
                    break;
                case 2:
                    searchAllItems(itemCRUD);
                    break;
                case 3:
                    searchSpecificItem(itemCRUD, scanner);
                    break;
                case 4:
                    updateItem(itemCRUD, scanner);
                    break;
                case 5:
                    deleteItem(itemCRUD, scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertItem(ItemCRUD itemCRUD, Scanner scanner) {
        System.out.println("\n--- Insert Item ---");
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter image name: ");
        String imageName = scanner.nextLine();
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();

        Item newItem = new Item(name, price, imageName, ownerName);
        itemCRUD.insertItem(newItem);
        System.out.println("Item inserted successfully.");
    }

    private static void searchAllItems(ItemCRUD itemCRUD) {
        System.out.println("\n--- All Items ---");
        List<Item> allItems = itemCRUD.getAllItems();
        for (Item item : allItems) {
            System.out.println(item);
        }
    }

    private static void searchSpecificItem(ItemCRUD itemCRUD, Scanner scanner) {
        System.out.println("\n--- Search Specific Item ---");
        System.out.print("Enter item ID to search: ");
        int id = scanner.nextInt();
        Item retrievedItem = itemCRUD.getItem(id);
        if (retrievedItem != null) {
            System.out.println("Found item: " + retrievedItem);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void updateItem(ItemCRUD itemCRUD, Scanner scanner) {
        System.out.println("\n--- Update Item ---");
        System.out.print("Enter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Item updateItem = itemCRUD.getItem(id);
        if (updateItem != null) {
            System.out.print("Enter new price: ");
            int newPrice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new image name: ");
            String newImageName = scanner.nextLine();

            updateItem.setPrice(newPrice);
            updateItem.setImgName(newImageName);
            itemCRUD.updateItem(updateItem);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void deleteItem(ItemCRUD itemCRUD, Scanner scanner) {
        System.out.println("\n--- Delete Item ---");
        System.out.print("Enter item ID to delete: ");
        int id = scanner.nextInt();
        itemCRUD.deleteItem(id);
        System.out.println("Item with ID " + id + " has been deleted.");
    }
}