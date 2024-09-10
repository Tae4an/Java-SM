package com.db;

public interface Db {
    void insert(Object object);
    void update(Object object);
    void delete(Object object);
    void search(Object object);
}
