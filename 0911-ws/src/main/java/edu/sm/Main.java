package edu.sm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemCRUD itemCRUD = new ItemCRUD();

        // Test Case 1: Insert item
        System.out.println("테스트 케이스 1: Insert item ");
        Item item1 = new Item( "노트북", 1000000, "laptop.jpg", "최태산");
        Item item2 = new Item( "키보드", 480000, "phone.jpg", "이은범");
        itemCRUD.insertItem(item1);
        itemCRUD.insertItem(item2);

        // Test Case 2: Search All item
        System.out.println("\nTest Case 2: Search All item ");
        List<Item> allItems = itemCRUD.getAllItems();
        for (Item item : allItems) {
            System.out.println(item);
        }

        // Test Case 3: Search for a specific item
        System.out.println("\n테스트 케이스 3: Search for a specific item");
        Item retrievedItem = itemCRUD.getItem(1);
        System.out.println("Search item: " + retrievedItem);

        // Test Case 4: Update item
        System.out.println("\nTest Case 4: Update item ");
        Item updateItem = itemCRUD.getItem(1);
        if (updateItem != null) {
            updateItem.setPrice(1200000);
            updateItem.setImgName("new_laptop.jpg");
            itemCRUD.updateItem(updateItem);
            Item updatedItem = itemCRUD.getItem(updateItem.getId());
            System.out.println("Updated item: " + updatedItem);
        }

//        // Test Cse 5: Delete item
//        System.out.println("\nTest Case 5: Delete item");
//        itemCRUD.deleteItem(1);
//        System.out.println("Delete item ID: 1 "  );

    }
}