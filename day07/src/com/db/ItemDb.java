package com.db;

public class ItemDb implements Db {
    @Override
    public void insert(Object object) {
        System.out.println("Insert Item"+ object);
    }

    @Override
    public void update(Object object) {
        System.out.println("Update Item"+ object);
    }

    @Override
    public void delete(Object object) {
        System.out.println("Delete Item"+ object);
    }

    @Override
    public void search(Object object) {
        System.out.println("Search Item"+ object);
    }
}
