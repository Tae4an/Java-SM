package repository;

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
        item = new Item(integer,"마우스", 22200,"마우스 사진");
        return item;
    }

    @Override
    public List<Item> select() throws Exception {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(100,"청바지",40000,"청바지 사진"));
        items.add(new Item(123,"모자",20000,"모자 사진"));
        items.add(new Item(122,"백팩",60000,"백팩 사진"));
        items.add(new Item(133,"책",40000, "책 사진"));
        items.add(new Item(144,"신발",30000,"신발 사진"));
        return items;
    }
}
