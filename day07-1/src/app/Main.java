package app;

import dto.Cust;
import dto.Item;
import frame.Db;
import repository.ItemDb;
import repository.CustDb;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Db<String, Cust> db = new CustDb();
        Cust cust = new Cust("id01", "pwd01", "taesan");
        try {
            System.out.println(db.select());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Cust> custs = null;
        try {
//            custs = db.select();
            custs = db.searchByName("장");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(Cust c : custs) {
            System.out.println(c);
        }


        Db<Integer,Item> itemDb = new ItemDb();
        Item item = new Item(0,"pants",1000);
        try {
            itemDb.insert(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int itemId = 100;
        Item dbItem;
        try {
            dbItem = itemDb.select(itemId);
            System.out.println(dbItem);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Item> items = null;
        try {
            items = itemDb.select();
            for(Item i : items) {
                System.out.println(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}
