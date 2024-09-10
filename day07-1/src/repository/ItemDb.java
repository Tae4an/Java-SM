package repository;

import dto.Cust;
import dto.Item;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

public class ItemDb implements Db<Integer, Item> {
    @Override
    public void insert(Item item) throws Exception {
        System.out.println("Insert Item"+item);
    }

    @Override
    public void update(Item item) throws Exception {
        System.out.println("Update Item"+item);
    }

    @Override
    public void delete(Integer integer) throws Exception {
        System.out.println("Delete Item"+integer);
    }

    @Override
    public Item select(Integer integer)throws  Exception {
        Item item = new Item();
        item = new Item(integer,"hat", 100);
        return item;
    }

    @Override
    public List<Item> select() throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(100,"pants1",10000));
        items.add(new Item(123,"pants2",20000));
        items.add(new Item(122,"pants3",60000));
        items.add(new Item(133,"pants4",40000));
        items.add(new Item(144,"pants5",30000));
        return items;
    }
}
